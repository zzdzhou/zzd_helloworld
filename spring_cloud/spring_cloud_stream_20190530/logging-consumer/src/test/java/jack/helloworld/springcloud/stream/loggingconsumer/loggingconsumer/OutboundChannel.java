package jack.helloworld.springcloud.stream.loggingconsumer.loggingconsumer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutboundChannel {

    String OUTBOUND = "inbound";

    @Output(OUTBOUND)
    MessageChannel outbound();
}
