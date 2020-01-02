package jack.web.mvcjpa.web.controller;

import jack.web.mvcjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String greeting(@RequestParam(name = "name", defaultValue = "new world!", required = false) String name, Model model) {
        Integer customerId = customerService.createCustomer(name);
        model.addAttribute("name", name);
        model.addAttribute("customerId", customerId);
        return "greeting";
    }
}
