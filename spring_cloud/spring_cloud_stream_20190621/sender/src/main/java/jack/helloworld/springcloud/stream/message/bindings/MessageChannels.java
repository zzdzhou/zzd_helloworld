package jack.helloworld.springcloud.stream.message.bindings;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageChannels {

    @Output
    MessageChannel organization();

}

