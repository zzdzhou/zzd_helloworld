package jack.helloworld.rabbitmq.r2.helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {
    public static final String QUEUE_NAME = "queue_20190618";
    public static final String EXCHANGE_NAME = "exchange_20190618";
    public static final String ROUTING_KEY = "queue_20190618_KEY";
    public static final String BINDING_KEY = "queue_20190618_KEY";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = null;
        Channel channel = null;

        try {
            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, BINDING_KEY);
            String message = "Hello rabbitmq, I'm back";
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes("UTF-8"));
            System.out.println("[x] sent '" + message + "'");

            // or use default exchange (direct type, no public name)
            // The default exchange is implicitly bound to every queue, with a routing key equal to the queue name.
            /*channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello rabbitmq, I'm back";
            channel.basicPublish("", ROUTING_KEY, null, message.getBytes("UTF-8"));*/
        } finally {
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
