package jack.helloworld.spring.cloud.config.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServiceApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ConfigServiceApp.class)
                .build()
                .run();
    }

}
