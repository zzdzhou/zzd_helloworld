package jack.helloworld.activiti.controller;

import jack.helloworld.activiti.pojo.param.ProjectParam;
import jack.helloworld.activiti.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public void applyNewProject(ProjectParam param) {
        projectService.applyNewProject(param);
    }

}
