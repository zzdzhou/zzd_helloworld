package jack.javaee.springmvcrest20181124.restcontroller;

import jack.javaee.springmvcrest20181124.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-11-29
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    @PostMapping(value = "/echo")
    public User user(@RequestBody User user) {
        return user;
    }

}
