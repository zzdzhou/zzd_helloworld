package jack.helloworld.jdbc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-08
 */
@WebServlet("/ds")
public class DsServlet extends HttpServlet {

    private DataSource ds;
    private Context ctx;

    @Override
    public void init() throws ServletException {
        System.out.println("log -- DsServlet init()");
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("datasources/mmalDS"); // JNDI Name java:/datasources/mmalDS
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Connection con = null;
        PreparedStatement pstmt = null;
        String email = null;
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement("select email from user where id = ?");
            pstmt.setInt(1, 3);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                email = resultSet.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        writer.printf("Hello, jdbc DataSource! Hello, %s!", email);
    }

    @Override
    public void destroy() {
        System.out.println("log -- DsServlet destroy()");
    }
}