package jack.helloworld.spring.security.api.mybatis.models;

import lombok.Data;

@Data
public class User {

    private int id;

    private String username;

    private String password;

    private Role role;

    public enum Role{
        ADMIN, COMMON
    }

}
