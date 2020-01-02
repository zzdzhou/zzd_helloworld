package jack.helloworld.mybatis.web;

import com.mysql.cj.jdbc.MysqlXADataSource;
import jack.helloworld.mybatis.web.mappers.LicenseMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MybatisWebApp {

    public static void main(String[] args) {
        SpringApplication.run(MybatisWebApp.class, args);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(MysqlXADataSource sysDs) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(sysDs);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /*@Bean
    public SqlSessionTemplate getSqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }*/

    /*@Bean
    public MapperFactoryBean<LicenseMapper> licenseMapper(SqlSessionFactory sessionFactory) {
        MapperFactoryBean<LicenseMapper> factoryBean = new MapperFactoryBean<>(LicenseMapper.class);
        factoryBean.setSqlSessionFactory(sessionFactory);
        return factoryBean;
    }*/


    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(sysDs());
    }

    /*
        二级 beans
    */
    @Bean
    public MysqlXADataSource sysDs() {
        MysqlXADataSource ds = new MysqlXADataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/spring_microservice?serverTimezone=UTC");
        ds.setUser("root");
        ds.setPassword("zzde123#");
        return ds;
    }

}
