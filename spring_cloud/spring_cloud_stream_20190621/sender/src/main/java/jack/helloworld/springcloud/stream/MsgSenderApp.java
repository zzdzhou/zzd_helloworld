package jack.helloworld.springcloud.stream;

import jack.helloworld.springcloud.stream.message.bindings.MessageChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(MessageChannels.class)
public class MsgSenderApp {

    public static void main(String[] args) {
        SpringApplication build = new SpringApplicationBuilder()
                .sources(MsgSenderApp.class)
                .build();
        build.run();
    }
}
