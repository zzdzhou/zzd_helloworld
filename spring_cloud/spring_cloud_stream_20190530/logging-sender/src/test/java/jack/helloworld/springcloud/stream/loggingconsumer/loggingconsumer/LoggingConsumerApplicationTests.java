package jack.helloworld.springcloud.stream.loggingconsumer.loggingconsumer;

import jack.helloworld.springcloud.stream.loggingconsumer.loggingconsumer.message.channels.OutboundChannel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(OutboundChannel.class)
public class LoggingConsumerApplicationTests {

	@Autowired
	private OutboundChannel outboundChannel;

	@Test
	public void contextLoads() {
		outboundChannel.outbound().send(MessageBuilder.withPayload("{\n" +
				"\t\"name\":\"Sam Spade\"\n" +
				"}").build());
	}

}
