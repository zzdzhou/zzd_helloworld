package jack.helloworld.mybatis.spring.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import jack.helloworld.mybatis.spring.mapper.ProductMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.config.JtaTransactionManagerFactoryBean;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan(value = "jack.helloworld.mybatis.spring",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = RestController.class))
public class RootConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mmalDs());
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/mappers/*Mapper.xml"));
        return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
    }

    @Bean
    public ProductMapper productMapper() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate.getMapper(ProductMapper.class);
    }

    @Bean
    public MysqlXADataSource mmalDs() {
        MysqlXADataSource ds = new MysqlXADataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/mmal?serverTimezone=UTC");
        ds.setUser("root");
        ds.setPassword("zzde123#");
        return ds;
    }

    @Bean
    public JtaTransactionManagerFactoryBean txManager() {
        return new JtaTransactionManagerFactoryBean();
    }

}







