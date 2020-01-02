package jack.helloworld.mybatis.typehandler.mybatis.mapper;

import jack.helloworld.mybatis.typehandler.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAllByParam(User user);

}
