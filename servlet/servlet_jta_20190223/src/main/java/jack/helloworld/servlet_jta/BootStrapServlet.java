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
 * # JTA / bean-managed transaction(BMT) / transaction in web component
 * # 4.1 Resource Injection
 *
 * Description:
 * # EJB CMT depends on EJB container, it is of declarative transaction management, but it is not available in web component
 * # In web component, bean-managed transaction is only option, you must decide
 * whether to use Java Database Connectivity(JDBC 本身也集成了transaction management功能) or JTA transactions.
 *          -- refer to JTA_20190222.vsdx
 *
 * # Resource injection enables you to inject any resource available in the JNDI namespace
 * into any container-managed object, such as a servlet, an enterprise bean, or a managed bean.
 * # please note: @Resource(lookup = "java:/datasources/mmalDS") instead of @Resource(name = "java:/datasources/mmalDS") for global JNDI name
 *
 * Next
 * # 请参考 Spring_Framework_Data_Access_20190217.vsdx /ORM-JPA /Obtaining an EntityManagerFactory from JNDI
 * 唯一的改变是：使用 JPA 而非 JDBC
 * 其他不变，比如 in web component(Servlet), 使用 JTA, 使用 Jboss EAP 7.2 上已配置好的 DataSource Object
 *
 * #This action assumes standard Java EE bootstrapping.
 * The Java EE server auto-detects persistence units (in effect, META-INF/persistence.xml files in application jars)
 * and persistence-unit-ref entries in the Java EE deployment descriptor (for example, web.xml)
 * and defines environment naming context locations for those persistence units.
 * The JDBC DataSource is defined through a JNDI location in the META-INF/persistence.xml file.
 * EntityManager transactions are integrated with the server’s JTA subsystem.
 * Spring merely uses the obtained EntityManagerFactory, passing it on to application objects through dependency injection
 * and managing transactions for the persistence unit (typically through JtaTransactionManager)
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

    /*
    // classic way to instantiate DataSource and UserTransaction
    @Override
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
            // if end without error, commit
            userTx.commit();
        } catch (Exception e) {
            try {
                System.out.println("log DEBUG -- rollback");
                // rollback if go to catch block
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
