package jack.project.grocery.grocery_springboot_20180503.config;

import jack.project.grocery.grocery_springboot_20180503.web.interceptor.AuthenticationInterceptor;
import jack.project.grocery.grocery_springboot_20180503.web.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class SpringWebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/customer/login");
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**/secure");
    }
}
