package jack.javaee.springmvcrest20181124.restcontroller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-11-27
 */
@RestController
public class HelloWorldRestController {

    @GetMapping("/helloworld")
    public String helloWorld(@RequestParam(name = "msg", required = false) String message) {
        return "hello world! " + message;
    }


}
