package com.ankur_karna.CustomerInsightPro.controller;

import com.ankur_karna.CustomerInsightPro.model.Purchase;
import com.ankur_karna.CustomerInsightPro.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/add/{customerId}/{productId}")
    public Purchase addPurchase(@PathVariable Long customerId, @PathVariable Long productId) {
        return purchaseService.addPurchase(customerId, productId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Purchase> getPurchasesByCustomer(@PathVariable Long customerId) {
        return purchaseService.getPurchasesByCustomer(customerId);
    }
}
