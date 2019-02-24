package jack.helloworld.jpa;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-24
 */
@Configuration
@ImportResource("classpath:spring_beans.xml")
@ComponentScan(basePackages = "jack.helloworld.jpa")
public class AppConfig {
}
