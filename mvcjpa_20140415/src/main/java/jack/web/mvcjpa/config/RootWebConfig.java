package jack.web.mvcjpa.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("jack.web.mvcjpa")
@EnableTransactionManagement
public class RootWebConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPersistenceXmlLocation("classpath:META-INF/my-persistence.xml");
        return emf;
    }

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/grocery");
        ds.setUsername("root");
        ds.setPassword("zzde");
        return ds;
    }

    @Bean
    public JpaTransactionManager txManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(emf());
        txManager.setPersistenceUnitName("myUnit");
        return txManager;
    }
}
