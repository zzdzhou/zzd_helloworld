package jack.helloworld.springcloud.stream.loggingconsumer.loggingconsumer.restcontroller;

import jack.helloworld.springcloud.stream.loggingconsumer.loggingconsumer.LoggingSenderApplication;
import jack.helloworld.springcloud.stream.loggingconsumer.loggingconsumer.message.channels.OutboundChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
@EnableBinding(OutboundChannel.class)
public class SendMsgController {

    @Autowired
    private OutboundChannel outboundChannel;

    @PostMapping("/person")
    public String send(@RequestBody LoggingSenderApplication.Person p) {
        outboundChannel.outbound().send(MessageBuilder.withPayload(p).build());
        System.out.println(p);
        return "success";
    }

}
