package jack.helloworld.rabbitmq.routing;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ReceiveLogDirect {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = null;
        Channel channel = null;

        try {
            con = factory.newConnection();
            channel = con.createChannel();

            channel.exchangeDeclare(EmitLogDirect.EXCHANGE_NAME, "direct");
            String queueName = null;
            if (args != null && args.length > 0) {
                queueName = args[0];
            }
            channel.queueDeclare(queueName, false, false, false, null);
            channel.queueBind(queueName, EmitLogDirect.EXCHANGE_NAME, queueName);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            };
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
