package jack.project.grocery.grocery_springboot_20180503.web.interceptor;

import jack.project.grocery.grocery_springboot_20180503.pojo.LoginUser;
import jack.project.grocery.grocery_springboot_20180503.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

/*    @Autowired
    private CustomerService customerService;*/

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Jack: LoginInterceptor postHandle()");
/*        String username = request.getParameter("emailOrPhone");
        String password = request.getParameter("password");
        LoginUser user = new LoginUser(username, password);*/
        if (0L != (Long)modelAndView.getModel().get("customerNumber")) {
            System.out.println("Jack: LoginInterceptor postHandle() setSession");
            request.getSession().setAttribute("user", modelAndView.getModel().get("user"));
        }
    }
}
