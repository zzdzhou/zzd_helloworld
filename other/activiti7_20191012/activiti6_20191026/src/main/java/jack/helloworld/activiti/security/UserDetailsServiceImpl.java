package jack.helloworld.activiti.security;

import com.alibaba.fastjson.JSONObject;
import jack.helloworld.activiti.mapper.EmployeeMapper;
import jack.helloworld.activiti.pojo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee e = employeeMapper.findUserByUsername(username);
        return JSONObject.parseObject(JSONObject.toJSONString(e), UserDetailsImpl.class);
    }
}
