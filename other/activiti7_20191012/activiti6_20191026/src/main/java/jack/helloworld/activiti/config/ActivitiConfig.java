package jack.helloworld.activiti.config;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ActivitiConfig implements ProcessEngineConfigurationConfigurer {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(SpringProcessEngineConfiguration c) {
        //表示启动的时候是否去创建表，如果第一次启动这里必须设置为true
        c.setDatabaseSchemaUpdate("true");
        c.setDataSource(dataSource);
    }

}
