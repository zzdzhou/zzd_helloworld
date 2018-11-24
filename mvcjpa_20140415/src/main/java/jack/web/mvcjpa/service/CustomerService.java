package jack.web.mvcjpa.service;

import jack.web.mvcjpa.dao.CustomerDao;
import jack.web.mvcjpa.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service("customerService")
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Integer createCustomer(String name) {
        Customer customer = new Customer(name, new Date(System.currentTimeMillis()));
        return customerDao.save(customer);
    }

}
