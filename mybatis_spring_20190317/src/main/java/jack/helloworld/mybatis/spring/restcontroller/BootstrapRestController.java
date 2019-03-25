package jack.helloworld.mybatis.spring.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatis-spring")
public class BootstrapRestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello mybatis";
    }

}
