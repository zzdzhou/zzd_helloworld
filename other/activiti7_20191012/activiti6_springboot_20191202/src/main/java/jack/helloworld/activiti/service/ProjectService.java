package jack.helloworld.activiti.service;

import jack.helloworld.activiti.pojo.param.ProjectParam;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static jack.helloworld.activiti.common.enums.BpmProcessEnum.PROJECT_APPROVAL_PROCESS;

@Service
public class ProjectService {

    @Autowired
    private RuntimeService runtimeService;

    public void applyNewProject(ProjectParam param) {
        // save project

        // start project_approval_process process
        runtimeService.startProcessInstanceByKey(PROJECT_APPROVAL_PROCESS.getProcessId());
    }


}
