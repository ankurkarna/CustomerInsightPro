package com.ankur_karna.CustomerInsightPro.service;

import com.ankur_karna.CustomerInsightPro.model.Customer;
import com.ankur_karna.CustomerInsightPro.model.Product;
import com.ankur_karna.CustomerInsightPro.model.Purchase;
import com.ankur_karna.CustomerInsightPro.repository.CustomerRepository;
import com.ankur_karna.CustomerInsightPro.repository.ProductRepository;
import com.ankur_karna.CustomerInsightPro.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public Purchase addPurchase(Long customerId, Long productId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setProduct(product);

        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getPurchasesByCustomer(Long customerId) {
        return purchaseRepository.findByCustomerId(customerId);
    }
}
