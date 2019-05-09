package jack.helloworld.mybatis.springboot.rest;

import jack.helloworld.mybatis.springboot.domain.User;
import jack.helloworld.mybatis.springboot.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bootstrap")
public class BootstrapRestController {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapRestController.class);

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/helloworld")
    public User helloWorld(@RequestParam String email) {
        logger.debug("request /bootstrap/helloworld?email=" + email);
        User user = userMapper.getByEmail(email);
        return user;
    }

    @GetMapping("/findByUsernameAndPassword")
    public User findByUsernameAndPassword(@RequestParam String username, @RequestParam String password) {
        User user = userMapper.getByUsernameAndPassword(username, password);
        return user;
    }

    @PostMapping(value = "/save", consumes = "application/json")
    public Integer saveUser(@RequestBody User user) {
        userMapper.save(user);
        return user.getId();
    }

}
