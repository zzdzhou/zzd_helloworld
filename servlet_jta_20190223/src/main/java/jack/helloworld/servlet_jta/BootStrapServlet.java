package jack.helloworld.servlet_jta;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-23
 */
@WebServlet("jta")
public class BootStrapServlet extends HttpServlet {

    // todo to use slf4j + log4j / to replace all System.out

    @Resource(lookup = "java:/datasources/mmalDS")
    private DataSource ds;

    @Resource
    private UserTransaction userTx;

    /*@Override
    public void init() throws ServletException {
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/datasources/mmalDS");
            userTx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        } catch (NamingException e) {
            // todo
            System.out.println("DataSource with JNDI name \"java:/datasources/mmalDS\" is not available");
            destroy();
            e.printStackTrace();
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con;
        Statement stmt;
        PreparedStatement pstmt;
        try {
            con = ds.getConnection();
            userTx.begin();

            pstmt = con.prepareStatement("UPDATE user SET question = 'update' WHERE id = ? LIMIT 1");
            pstmt.setInt(1, 3);
            int i = pstmt.executeUpdate();
            System.out.println("log DEBUG -- execute update 1");

            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE user SET question = 'update' WHERE id = 4 LIMIT 1");
            System.out.println("log DEBUG -- execute update 2");

            pstmt.setInt(1, 12);
            pstmt.executeUpdate();
            System.out.println("log DEBUG -- execute update 3");
            // not commit if go to catch block before
            userTx.commit();
        } catch (Exception e) {
            try {
                System.out.println("log DEBUG -- rollback");
                userTx.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        PrintWriter writer = resp.getWriter();
        writer.println("Hello World! Hello, JTA!");
    }
}
