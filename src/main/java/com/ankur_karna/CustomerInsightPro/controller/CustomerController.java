package com.ankur_karna.CustomerInsightPro.controller;

import com.ankur_karna.CustomerInsightPro.model.Customer;
import com.ankur_karna.CustomerInsightPro.repository.CustomerRepository;
import com.ankur_karna.CustomerInsightPro.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted!";
    }
    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }


}
