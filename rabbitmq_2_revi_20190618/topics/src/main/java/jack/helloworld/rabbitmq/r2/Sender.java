package jack.helloworld.rabbitmq.r2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Sender {

    static final String EXCHANGE_NAME = "topic_20190620";

    public static void main(String[] args) throws IOException, TimeoutException {
        String message = args[0];
        String routingKey = args[1];

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection con = null;
        Channel channel = null;

        try {
            con = factory.newConnection();
            channel = con.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes(StandardCharsets.UTF_8));
        } finally {
            if (channel != null) {
                channel.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }
}
