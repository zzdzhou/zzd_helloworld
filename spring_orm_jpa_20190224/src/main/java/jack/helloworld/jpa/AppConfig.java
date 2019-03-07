package jack.helloworld.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-24
 */
@Configuration
//@ImportResource("classpath:spring_beans.xml")
@ComponentScan(basePackages = "jack.helloworld.jpa")
@EnableTransactionManagement
public class AppConfig {

   /* @Bean
    public JndiObjectFactoryBean emf() {
        JndiObjectFactoryBean emf = new JndiObjectFactoryBean();
        emf.setJndiName("java:/mmalUnitEntityManagerFactory");
        return emf;
    }*/

    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        return emf;
    }

    @Bean
    public JtaTransactionManager txManager() {
        return new JtaTransactionManager();
    }

}
