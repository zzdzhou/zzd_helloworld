package jack.project.grocery.grocery_springboot_20180503.web.interceptor;

import jack.project.grocery.grocery_springboot_20180503.pojo.LoginUser;
import jack.project.grocery.grocery_springboot_20180503.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Jack: AuthenticationInterceptor preHandle()");
        LoginUser user = (LoginUser) request.getSession().getAttribute("user");
        if (0L == customerService.authenticateCustomer(user).longValue()) {
            response.sendRedirect("/goodthymes");
            return false;
        }
        return true;
        /*true if the execution chain should proceed with the next interceptor or the handler itself.
        Else, DispatcherServlet assumes that this interceptor has already dealt with the response itself.*/
    }

}
