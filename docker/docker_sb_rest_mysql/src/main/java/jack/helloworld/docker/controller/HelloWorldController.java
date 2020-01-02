package jack.helloworld.docker.controller;

import jack.helloworld.docker.entity.User;
import jack.helloworld.docker.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String hello() {
        String hello = String.format("Hello %s! Hello Docker", userMapper.findOne(3).map(User::getName).orElse("Zhengde"));
        log.info(hello);
        return hello;
    }
}
