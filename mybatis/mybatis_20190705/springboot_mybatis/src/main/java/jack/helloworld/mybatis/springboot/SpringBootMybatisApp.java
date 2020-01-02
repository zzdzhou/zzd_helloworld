package jack.helloworld.mybatis.springboot;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringBootMybatisApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApp.class);
    }

    // Autodetect an existing DataSource
    @Bean
    public DataSource dataSource() {
        MysqlXADataSource ds = new MysqlXADataSource();
        ds.setURL("jdbc:mysql://localhost:3306/spring_microservice?serverTimeZone=UTC");
        ds.setUser("root");
        ds.setPassword("zzde123#");
        return ds;
    }

    // SqlSessionFactory
    // Will create and register an instance of a SqlSessionFactory passing that DataSource as an input using the SqlSessionFactoryBean

    // Will create and register an instance of a SqlSessionTemplate got out of the SqlSessionFactory
    // by default, autoscans mappers marked with the @Mapper annotation, link them to the SqlSessionTemplate

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }



}
