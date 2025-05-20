package com.ankur_karna.CustomerInsightPro.repository;



import com.ankur_karna.CustomerInsightPro.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLocation(String location);
}
