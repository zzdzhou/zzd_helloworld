package jack.helloworld.jpa;

import com.google.protobuf.WireFormat;
import jack.helloworld.jpa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-25
 */
@WebServlet("jpa")
@Controller
public class BootstrapServlet extends HttpServlet {

    @Autowired
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = userDao.getEmail(3);
//        System.out.printf("Hello World! Hello, %s", email);
        PrintWriter writer = resp.getWriter();
        writer.printf("Hello %s!", email);
    }

}
