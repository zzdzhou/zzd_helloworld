package jack.helloworld.spring.security.api.mybatis.mappers;

import jack.helloworld.spring.security.api.mybatis.models.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User getByUsername(String username);

    List<User> getAllUser();

    List<User> getByRole(Integer role);

}
