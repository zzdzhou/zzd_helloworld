package jack.helloworld.jpa;

import jack.helloworld.jpa.dao.UserDao;
import jack.helloworld.jpa.entity.EUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

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
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = userDao.getEmail(3);

        EUser eUser = new EUser();
        eUser.setUsername(req.getParameter("username"));
        eUser.setPassword("pass 1");
        eUser.setEmail("eUser1@163.com");
        eUser.setRole(EUser.Role.USER);
        eUser.setCreateTime(LocalDateTime.now());
        eUser.setUpdateTime(LocalDateTime.now());
        userDao.addUser(eUser);

        PrintWriter writer = resp.getWriter();
        writer.printf("Hello %s!", email);
    }

}
