package jack.helloworld.redis;

import jack.helloworld.redis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOperations;

    public static void main(String[] args) {
        new SpringApplicationBuilder(RedisApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        valueOperations.set("username", "jack1");
        hashOperations.put("User", "1", new User("Jack", "15821127849", LocalDate.now()));
    }

}
