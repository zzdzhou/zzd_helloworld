package jack.project.grocery.grocery_springboot_20180503.service;

import jack.project.grocery.grocery_springboot_20180503.dao.CustomerRepo;
import jack.project.grocery.grocery_springboot_20180503.enities.Customer;
import jack.project.grocery.grocery_springboot_20180503.pojo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Long authenticateCustomer(LoginUser user) {
        if (user != null && user.getEmailOrPhone() != null && user.getPassword() != null) {
            Customer customer = customerRepo.findCustomerByEmailOrPhone(user.getEmailOrPhone(), user.getEmailOrPhone());
            if (customer != null && customer.getPassword().equals(user.getPassword()))
                return customer.getId();
        }
        return Long.valueOf(0L);
    }
}
