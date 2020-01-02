package jack.helloworld.mybatis.typehandler.controller;

import jack.helloworld.mybatis.typehandler.entities.User;
import jack.helloworld.mybatis.typehandler.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<User> user(@RequestBody User user) {
        List<User> userList = userMapper.findAllByParam(user);
        System.out.println(userList);
        return userList;
    }
}
