package jack.helloworld.rabbitmq.r2;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        String queueName = args[0];
        String bindingKey = args[1];

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(Sender.EXCHANGE_NAME, "topic");
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, Sender.EXCHANGE_NAME, bindingKey);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println("[x] message" + message);
        };
        channel.basicConsume(queueName, deliverCallback, consumerTag -> {});
    }

}
