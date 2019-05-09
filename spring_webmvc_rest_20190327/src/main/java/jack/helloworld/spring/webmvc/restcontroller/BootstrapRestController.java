package jack.helloworld.spring.webmvc.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bootstrap")
public class BootstrapRestController {

    @GetMapping(value = "/hello", produces = "text/plain;charset=utf-8")
    public String hello() {
        return "hello！你好";
    }

}
