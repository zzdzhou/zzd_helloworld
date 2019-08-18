package jack.helloworld.springcloud.stream.loggingconsumer.loggingconsumer.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {

    public static final String EXCHANGE_NAME = "input";
    public static final String ROUTING_KEY = "input.anonymous.7-qNpWLMTli0PEbeHW0K3w";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection con = null;
        Channel channel = null;

        try {
            con = factory.newConnection();
            channel = con.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, "topic", true);
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, "{\"name\":\"Sam Spade\"}".getBytes("UTF-8"));
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
