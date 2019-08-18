package jack.helloworld.rabbitmq.r2;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Sender {

    static final String EXCHANGE_NAME = "routing_exchange_20190620";
    static final String QUEUE_NAME = "routing_exchange_20190620";
    static final String ROUTING_KEY = "routing_exchange_20190620";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection con = null;
        Channel channel = null;

        try {
            con = factory.newConnection();
            channel = con.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            String message = "";
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes(StandardCharsets.UTF_8));
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
