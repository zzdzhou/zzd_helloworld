package jack.helloworld.redis.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class User implements Serializable {

    private String username;

    private String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public User() {
    }

    public User(String username, String phone, LocalDate birthday) {
        this.username = username;
        this.phone = phone;
        this.birthday = birthday;
    }
}
