package jack.helloworld.springcloud.consumer.messaging.bindings;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageChannels {

    String ORGANIZATION_CHANNEL = "organization";

    @Input(ORGANIZATION_CHANNEL)
    SubscribableChannel organization();
}
