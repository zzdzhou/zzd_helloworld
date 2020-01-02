package jack.helloworld.springcloud.stream.loggingconsumer.loggingconsumer.message.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InboundChannel {

    String INBOUND = "inbound";

    @Input(INBOUND)
    SubscribableChannel inbound();
}
