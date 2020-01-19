package jack.helloworld.activiti.controller;

import com.alibaba.fastjson.JSONObject;
import jack.helloworld.activiti.common.ReturnCode;
import jack.helloworld.activiti.pojo.entity.Employee;
import jack.helloworld.activiti.pojo.param.LoginParam;
import jack.helloworld.activiti.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    /*@PostMapping("/activiti/login")
    public JSONObject login(@RequestBody LoginParam param) {
        try {
            employeeService.login(param);
        } catch (Exception e) {

        }
        return null;
    }*/

    @PostMapping("/employee/askForLeave")
    public JSONObject askForLeave() {
        try {
            employeeService.askForLeave();
        } catch (Exception e) {

        }
        return null;
    }

    @PostMapping("/employee/approve")
    public JSONObject approveForLeave() {
        try {
            employeeService.askForLeave();
        } catch (Exception e) {

        }
        return null;
    }

    @PostMapping("/employee/create")
    private JSONObject createEmployee(@RequestBody Employee employee) {
        try {
            return success(new Employee(employeeService.createEmployee(employee)));
        } catch (Exception e) {
            logger.error("/employee/create error", e);
            return error(ReturnCode.FAILURE, e);
        }
    }
}
