package fr.fms.api.trainings.web;

import fr.fms.api.trainings.entities.Customer;
import fr.fms.api.trainings.entities.Training;
import fr.fms.api.trainings.service.ImplCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class CustomerController {
    @Autowired
    private ImplCustomerService implCustomerService;
    @GetMapping("/customer")
    public List<Customer> allCustomer(){
        return implCustomerService.getCustomers();
    }

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer t){
        System.out.println(t);
        return implCustomerService.saveCustomer(t);
    }
}
