package jack.helloworld.docker.mybatis.mapper;

import jack.helloworld.docker.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    Optional<User> findOne(Integer id);
}
