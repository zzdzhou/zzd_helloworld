package jack.helloworld.spring.security.api.rest;

import jack.helloworld.spring.security.api.mybatis.mappers.UserMapper;
import jack.helloworld.spring.security.api.mybatis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list")
    public List<User> getUserList() {
        return userMapper.getAllUser();
    }

    @GetMapping("/list/notfiltered")
    public List<User> getUserListNotFiltered() {
        return userMapper.getAllUser();
    }

}
