package jack.helloworld.springcloud.consumer;

import jack.helloworld.springcloud.consumer.messaging.bindings.MessageChannels;
import jack.helloworld.springcloud.consumer.messaging.models.OrganizationChangeModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@SpringBootApplication
@EnableBinding(MessageChannels.class)
public class ConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }

    @StreamListener(MessageChannels.ORGANIZATION_CHANNEL)
    public void organizationChange(OrganizationChangeModel organizationChangeModel) {
        System.out.println(organizationChangeModel);
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
        return new JedisConnectionFactory(config);
    }


}
