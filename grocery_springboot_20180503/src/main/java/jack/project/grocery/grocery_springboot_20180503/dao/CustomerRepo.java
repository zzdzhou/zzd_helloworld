package jack.project.grocery.grocery_springboot_20180503.dao;

import jack.project.grocery.grocery_springboot_20180503.enities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

//    Customer findCustomerByEmail(String email);

//    Customer findCustomerByPhone(String phone);

    Customer findCustomerByEmailOrPhone(String email, String phone);

}
