package table;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class ActivitiTest {


    @Test
    public void testGenTable(){
        //创建ProcessEngineConfiguration
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //通过ProcessEngineConfiguration创建ProcessEngine，此时会创建数据库
        ProcessEngine processEngine =
                configuration.buildProcessEngine();
        System.out.println(processEngine);
    }
}
