package jack.helloworld.spring.orm.jpa.context;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * Theme:
 * <p> Spring framework data access /ORM /JPA / LocalContainerEntityManagerFactoryBean
 *
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-21
 */
@Configuration
@ComponentScan(basePackages = "jack.helloworld.spring.orm.jpa")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEmf() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        // links to an existing JDBC DataSource instead of DataSource JNDI lookup
        // <jta-data-source> tag in persistence.xml
        // This is an alternative to keeping the JDBC configuration in {@code persistence.xml}, passing in a Spring-managed DataSource instead.
//        emf.setJtaDataSource(mysqlXADataSource());
        // <non-jta-data-source>
        // emf.setDataSource(mysqlXADataSource());

        // avoid persistence.xml location conflict between spring and the built-in JPA capabilities of a Java EE server.
        emf.setPersistenceXmlLocation("classpath:META-INF/spring-persistence.xml");
        emf.setPersistenceUnitName("mmalUnit");
        return emf;
    }

    /*@Bean
    public LocalContainerEntityManagerFactoryBean remoteEmf() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setJtaDataSource(mysqlXADataSource());
        emf.setPersistenceXmlLocation("classpath:META-INF/spring-persistence.xml");
        emf.setPersistenceUnitName("timesheetUnit");
        return emf;
    }

    @Bean
    public MysqlXADataSource mysqlXADataSource() {
        MysqlXADataSource ds = new MysqlXADataSource();
        ds.setUrl("jdbc:mysql://zzdzhou.cn:3306/timesheet?serverTimezone=UTC");
        ds.setUser("root");
        ds.setPassword("160Jack#");
        return ds;
    }*/

    @Bean
    public JtaTransactionManager txManager() {
        return new JtaTransactionManager();
    }

}

