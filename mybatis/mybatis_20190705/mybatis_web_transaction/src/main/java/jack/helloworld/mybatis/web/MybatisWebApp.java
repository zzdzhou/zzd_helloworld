package jack.helloworld.mybatis.web;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("jack.helloworld.mybatis.web.mappers")
public class MybatisWebApp {

    public static void main(String[] args) {
        SpringApplication.run(MybatisWebApp.class);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory factory) {
        return new SqlSessionTemplate(factory);
    }


    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }


    /*
    二级 beans
     */
    @Bean
    public DataSource dataSource() {
        MysqlXADataSource ds = new MysqlXADataSource();
        ds.setURL("jdbc:mysql://localhost:3306/spring_microservice?serverTimeZone=GMT");
        ds.setUser("root");
        ds.setPassword("zzde123#");
        return ds;
    }




}
