package jack.helloworld.spring.orm.jpa;

import jack.helloworld.spring.orm.jpa.dao.UserDao;
import jack.helloworld.spring.orm.jpa.entity.EUser;
import jack.helloworld.spring.orm.jpa.entity.remotedb.RUser;
import jack.helloworld.spring.orm.jpa.service.UserService;
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
 * Created on 2019-02-21
 */
@Controller
@WebServlet("/spring-jpa")
public class Bootstrap extends HttpServlet {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = userDao.getEmail(12);

        EUser eUser = new EUser();
        eUser.setUsername(req.getParameter("username"));
        eUser.setPassword("pass 1");
        eUser.setEmail("eUser1@163.com");
        eUser.setRole(EUser.Role.USER);
        eUser.setCreateTime(LocalDateTime.now());
        eUser.setUpdateTime(LocalDateTime.now());
        userService.save2User(eUser, new RUser("rUser1@gmail.com", "rUser 1", "rUser", "pass_ruser"));

        PrintWriter writer = resp.getWriter();
        writer.printf("Hello, spring orm jpa /LocalContainerEntityManagerFactoryBean! Hello, %s", email);
    }

}





