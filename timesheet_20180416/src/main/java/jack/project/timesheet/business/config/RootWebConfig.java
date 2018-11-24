package jack.project.timesheet.business.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("jack.project.timesheet.business")
@EnableTransactionManagement
public class RootWebConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceXmlLocation("classpath*:META-INF/my-persistence.xml");
        emf.setDataSource(dataSource());
        return emf;
    }

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/zhibernate");
        ds.setUsername("root");
        ds.setPassword("zzde");
        return ds;
    }

    @Bean
    public JpaTransactionManager txManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setPersistenceUnitName("zhibernateUnit");
        return txManager;
    }
}
