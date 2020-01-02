package jack.helloworld.springboot.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BootstrapApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(BootstrapApp.class)
                .build()
                .run(args);
    }

}










