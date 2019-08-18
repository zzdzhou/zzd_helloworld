package jack.helloworld.rabbitmq.r2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Subscribe {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection con = factory.newConnection();
        Channel channel = con.createChannel();
        // when no parameters to queueDeclare() we create a non-durable, exclusive, autodelete queue with a generated name:
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, Publish.EXCHANGE_NAME, "");
        System.out.println("queueName " + queueName);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println("[x] received " + message);
        };
        channel.basicConsume(queueName, deliverCallback, consumerTag -> {});
    }
}
