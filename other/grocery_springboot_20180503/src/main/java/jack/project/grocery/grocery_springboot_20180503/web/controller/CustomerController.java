package jack.project.grocery.grocery_springboot_20180503.web.controller;

import jack.project.grocery.grocery_springboot_20180503.dao.CustomerRepo;
import jack.project.grocery.grocery_springboot_20180503.enities.Customer;
import jack.project.grocery.grocery_springboot_20180503.pojo.LoginUser;
import jack.project.grocery.grocery_springboot_20180503.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.jws.WebParam;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
//    RequestMappingHandlerMapping

    @Autowired /*how if no setter for this field*//*no effect*/
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list/secure")
    public String customerList(Model model) {
        Iterable<Customer> customers = customerRepo.findAll(); /*how if customers is a Iterable instead of list*//*Iterable is also ok with #lists.isEmpty()*/
        /*ArrayList<Customer> customers = new ArrayList<>();
        if (cust.iterator().hasNext()) {
            for (Customer item : cust) {
                customers.add(item);
            }
        }*/
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @PostMapping("/registration/result")
    public String registration(Customer customer, Model model) {
        if (customer != null && customer.getFirstname() != null && customer.getLastname() != null && customer.getEmail() != null) {
            customer.setRegistrationDate(new Date(new java.util.Date().getTime()));
            customerRepo.save(customer);
            model.addAttribute("customer", customer);
        }
        return "customer/info";
    }

    @GetMapping("/info/secure")
    public String showInfo(Long customerNumber) {
//        customerRepo.findById(customerNumber);
        return "customer/info";
    }

    @PostMapping("/login")
    public ModelAndView login(/*Model model, */LoginUser user) {
        ModelAndView modelAndView = new ModelAndView();
        Long customerNumber = customerService.authenticateCustomer(user);
//        model.addAttribute("customerNumber", customerNumber);
        modelAndView.addObject("customerNumber", customerNumber);
        if (customerNumber != 0L) {
            modelAndView.addObject("user", user);
            modelAndView.setViewName(UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/customer/menu.html");
            return modelAndView;
        }
        modelAndView.addObject("error", "Please try again!");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
