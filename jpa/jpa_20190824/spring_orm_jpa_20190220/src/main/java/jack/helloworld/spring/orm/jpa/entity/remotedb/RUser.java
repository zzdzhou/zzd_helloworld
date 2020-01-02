package jack.helloworld.spring.orm.jpa.entity.remotedb;

import javax.persistence.*;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-03-06
 */
@Entity
@Table(name = "user")
public class RUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;

    @Column(name = "full_name")
    private String fullName;

    private String username;

    private String password;

    public RUser() {
    }

    public RUser(String email, String fullName, String username, String password) {
        this.email = email;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
