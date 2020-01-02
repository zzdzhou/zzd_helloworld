package jack.helloworld.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ServerApp.class, args);
    }
}
