package jack.helloworld.springcloud.circuitbreaker.servlet.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Component
@WebFilter({"/recommended"})
public class ReadingListFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println(httpRequest.getHeader("tmx-user-id"));
        chain.doFilter(request, response);
    }
}
