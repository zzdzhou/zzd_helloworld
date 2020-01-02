package jack.helloworld.spring.security.api.common.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Properties {

    @Value("${my.datasource.url}")
    private String dataSourceUrl;

    @Value("${my.datasource.username}")
    private String dataSourceUsername;

    @Value("${my.datasource.password}")
    private String dataSourcePassword;

}
