package jack.helloworld.spring.webmvc.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bootstrap")
public class BootstrapRestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello！";
    }

}
