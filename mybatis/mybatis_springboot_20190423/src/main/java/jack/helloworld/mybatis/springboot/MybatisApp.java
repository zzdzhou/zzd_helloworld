package jack.helloworld.mybatis.springboot;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class MybatisApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(MybatisApp.class)
                .build()
                .run();
    }

    @Bean
    public DataSource dataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/mmal?serverTimezone=UTC");
        ds.setUser("root");
        ds.setPassword("zzde123#");
        return ds;
    }

}
