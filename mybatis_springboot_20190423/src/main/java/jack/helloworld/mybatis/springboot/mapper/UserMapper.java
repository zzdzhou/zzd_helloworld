package jack.helloworld.mybatis.springboot.mapper;

import jack.helloworld.mybatis.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    int save(User user);

    User getById(int id);

    User getByUsername(String username);

    User getByEmail(String email);

    User getByUsernameAndPassword(String username, String password);

    User getByIdAndPassword(int id, String password);

    String getQuestionByUsername(String username);


}

