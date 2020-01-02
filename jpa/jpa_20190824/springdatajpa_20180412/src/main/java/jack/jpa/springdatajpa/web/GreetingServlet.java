package jack.jpa.springdatajpa.web;

import jack.jpa.springdatajpa.config.SpringBeans;
import jack.jpa.springdatajpa.dao.CustomerDao;
import jack.jpa.springdatajpa.entities.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeans.class);
        CustomerDao customerDao = ctx.getBean(CustomerDao.class);
        customerDao.save(new Customer("jack", new Date(System.currentTimeMillis())));

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html lang=\"en\">"
                    + "<head><title>Servlet Hello</title></head>");

            // then write the data of the response
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<img src=\"duke.waving.gif\" "
                    + "alt=\"Duke waving his hand\">"
                    + "<form method=\"get\">"
                    + "<h2>Hello, my name is Duke. What's yours?</h2>"
                    + "<input title=\"My name is: \"type=\"text\" "
                    + "name=\"username\" size=\"25\">"
                    + "<p></p>"
                    + "<input type=\"submit\" value=\"Submit\">"
                    + "<input type=\"reset\" value=\"Reset\">"
                    + "</form>");

            String username = req.getParameter("username"); // get parameters from request
            if (username != null && username.length()> 0) {
                RequestDispatcher dispatcher =
                        getServletContext().getRequestDispatcher("/response"); // refer to other servlet

                if (dispatcher != null) {
                    dispatcher.include(req, resp);
                }
            }
            out.println("</body></html>");
        }
    }
}
