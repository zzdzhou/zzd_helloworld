package jack.helloworld.mybatis.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MybatisApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(MybatisApp.class)
                .build()
                .run();
    }

}
