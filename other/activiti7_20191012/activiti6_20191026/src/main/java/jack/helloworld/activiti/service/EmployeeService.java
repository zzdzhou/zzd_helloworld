package jack.helloworld.activiti.service;

import jack.helloworld.activiti.mapper.EmployeeMapper;
import jack.helloworld.activiti.pojo.entity.Employee;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void askForLeave() {

    }

    public Integer createEmployee(Employee employee) throws Exception {
        validateParam(employee);
        String rawPassword = employee.getPassword();
        employee.setRawPassword(rawPassword);
        employee.setPassword(passwordEncoder.encode(rawPassword));
        employeeMapper.insertOne(employee);
        return employee.getId();
    }

    private void validateParam(Employee employee) throws Exception {
        if (employee == null || StringUtils.isBlank(employee.getUsername()) || StringUtils.isBlank(employee.getPassword())) {
            throw new Exception("参数错误");
        }
    }



}
