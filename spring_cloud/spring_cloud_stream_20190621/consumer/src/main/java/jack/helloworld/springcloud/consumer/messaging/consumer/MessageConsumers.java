package jack.helloworld.springcloud.consumer.messaging.consumer;

import jack.helloworld.springcloud.consumer.messaging.bindings.MessageChannels;
import jack.helloworld.springcloud.consumer.messaging.models.OrganizationChangeModel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MessageChannels.class)
public class MessageConsumers {



}
