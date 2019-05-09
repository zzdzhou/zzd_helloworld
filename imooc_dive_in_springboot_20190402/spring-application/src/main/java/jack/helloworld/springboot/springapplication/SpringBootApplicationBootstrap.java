package jack.helloworld.springboot.springapplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;

import java.util.HashSet;

public class SpringBootApplicationBootstrap {

    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add(SpringBootApplicationBootstrap.class.getName());

        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(strings);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);


    }
}
