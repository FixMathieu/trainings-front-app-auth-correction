package fr.fms.api.trainings.service;

import fr.fms.api.trainings.dao.CustomerRepository;
import fr.fms.api.trainings.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplCustomerService implements ICustomerService{

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();}
    public Customer saveCustomer(Customer t) {
        return customerRepository.save(t);
    }
}
