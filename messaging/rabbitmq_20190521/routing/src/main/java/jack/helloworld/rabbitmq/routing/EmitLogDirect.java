package jack.helloworld.rabbitmq.routing;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EmitLogDirect {

    public static final String EXCHANGE_NAME = "logs";
    public static final String INFO_LOG_QUEUE_NAME = "info";
    public static final String ERROR_LOG_QUEUE_NAME = "error";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection con = null;
        Channel channel = null;

        try {
            con = factory.newConnection();
            channel = con.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            String error = "ERROR : NullPointerException";
            String info = "INFO : done.";
            channel.basicPublish(EXCHANGE_NAME, INFO_LOG_QUEUE_NAME, null, error.getBytes("UTF-8"));
            System.out.println("[x] sent '" + error + "'");
            channel.basicPublish(EXCHANGE_NAME, ERROR_LOG_QUEUE_NAME, null, info.getBytes("UTF-8"));
            System.out.println("[x] sent '" + info + "'");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
