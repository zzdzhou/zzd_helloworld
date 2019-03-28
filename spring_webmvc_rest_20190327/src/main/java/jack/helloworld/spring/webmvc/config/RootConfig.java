package jack.helloworld.spring.webmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan(value = "jack.helloworld.spring.webmvc", excludeFilters = @ComponentScan.Filter(value = RestController.class))
public class RootConfig {

}
