package jack.helloworld.spring.security.api;

import com.mysql.cj.jdbc.MysqlDataSource;
import jack.helloworld.spring.security.api.common.properties.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@SpringBootApplication
public class WebApiSecurityApp {

    @Autowired
    private Properties properties;

    public static void main(String[] args) {
        SpringApplication.run(WebApiSecurityApp.class, args);
    }

    @Bean
    public DataSource dataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUser(properties.getDataSourceUsername());
        ds.setPassword(properties.getDataSourcePassword());
        ds.setUrl(properties.getDataSourceUrl());
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
