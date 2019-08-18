package jack.helloworld.spring.security.api.security;

import jack.helloworld.spring.security.api.mybatis.mappers.UserMapper;
import jack.helloworld.spring.security.api.mybatis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getByUsername(username);
        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), Arrays.asList(new Role("admin")));
    }

}
