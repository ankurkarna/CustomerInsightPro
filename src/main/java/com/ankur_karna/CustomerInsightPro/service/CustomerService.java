package com.ankur_karna.CustomerInsightPro.service;


import com.ankur_karna.CustomerInsightPro.model.Customer;
import com.ankur_karna.CustomerInsightPro.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getCustomersByLocation(String location) {
        return customerRepository.findByLocation(location);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @PostConstruct
    public void testDatabase() {
        System.out.println("Total Customers: " + customerRepository.count());
    }
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setLocation(updatedCustomer.getLocation());
        // Add any more fields you need to update

        return customerRepository.save(existingCustomer);
    }

}
