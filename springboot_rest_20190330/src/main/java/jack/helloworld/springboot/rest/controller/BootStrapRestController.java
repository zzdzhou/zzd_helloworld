package jack.helloworld.springboot.rest.controller;

import jack.helloworld.springboot.rest.models.ParamModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/bootstrap")
public class BootStrapRestController {

    @GetMapping("/hello")
    public String hello(ParamModel param) {
        System.out.println("hello world! hello docker");
        System.out.println(param);
        return "hello world! hello docker";
    }

}
