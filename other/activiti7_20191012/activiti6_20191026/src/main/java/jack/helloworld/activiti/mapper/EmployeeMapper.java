package jack.helloworld.activiti.mapper;

import jack.helloworld.activiti.pojo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee findUserByUsername(String username);

    Integer insertOne(Employee employee);
}
