package jack.helloworld.spring.security.api.rest;

import jack.helloworld.spring.security.api.mybatis.mappers.UserMapper;
import jack.helloworld.spring.security.api.mybatis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public List<User> getUserListByRole() {
        return userMapper.getByRole(User.Role.COMMON.ordinal());
    }

    @GetMapping("/list/notfiltered")
    public List<User> getUserListByRoleNotFiltered() {
        return userMapper.getByRole(User.Role.COMMON.ordinal());
    }

    @GetMapping("/list/method_invocation")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUserListByRoleMehtodInvocation() {
        return userMapper.getByRole(User.Role.COMMON.ordinal());
    }
}
