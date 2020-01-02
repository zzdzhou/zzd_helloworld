package jack.helloworld.rabbitmq.publishsubscribe;

import com.rabbitmq.client.*;

public class ReceiveLogs {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection con = factory.newConnection();
        Channel channel = con.createChannel();

        channel.exchangeDeclare(EmitLog.EXCHANGE_NAME, "fanout");
        // supply no parameters to queueDeclare() we create a non-durable, exclusive, autodelete queue with a generated name
        String queueName = channel.queueDeclare().getQueue();
        // 1.A message queue binds to the exchange with no arguments.
        // 'routingKey' must be non-null.
        channel.queueBind(queueName, EmitLog.EXCHANGE_NAME, "");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        //channel.basicQos(1);  // accept only one unack-ed message at a time
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
    }

}
