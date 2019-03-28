package jack.helloworld.spring.webmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("jack.helloworld.spring.webmvc.restcontroller")
@EnableWebMvc
public class ServletConfig/* implements WebMvcConfigurer */{

}
