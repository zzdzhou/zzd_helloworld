package jack.helloworld.activiti.pojo.entity;

import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.Set;

@Data
public class Employee implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String rawPassword;

    private String phone;

    private String email;

    private Set<SimpleGrantedAuthority> authorities;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }
}
