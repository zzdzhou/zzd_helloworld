package jack.helloworld.springcloud.config.client.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${example.property}")
    private String example;

    public String getExample() {
        return example;
    }

}
