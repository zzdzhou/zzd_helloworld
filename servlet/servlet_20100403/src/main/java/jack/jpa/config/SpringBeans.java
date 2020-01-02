package jack.jpa.config;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import jack.jpa.dao.OrderDao;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan("jack")
@EnableTransactionManagement
public class SpringBeans {

/*
    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean
    public AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor() {
        return new AutowiredAnnotationBeanPostProcessor();
    }
*/

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceXmlLocation("classpath*:META-INF/my-persistence.xml");
//        emf.setDataSource((DataSource)dataSource());
        return emf;
    }

    @Bean
    public JpaTransactionManager txMananger() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory((EntityManagerFactory) entityManagerFactory());
        return txManager;
    }


}
