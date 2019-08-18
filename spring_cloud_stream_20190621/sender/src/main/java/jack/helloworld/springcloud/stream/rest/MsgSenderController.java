package jack.helloworld.springcloud.stream.rest;

import jack.helloworld.springcloud.stream.message.bindings.MessageChannels;
import jack.helloworld.springcloud.stream.message.model.OrganizationChangeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MsgSenderController {

    @Autowired
    private MessageChannels msgChannels;

    @PostMapping("/send")
    public void sendMessage(@RequestBody OrganizationChangeModel org) {
        msgChannels.organization().send(MessageBuilder.withPayload(org).build());
    }
}
