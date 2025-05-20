package com.ankur_karna.CustomerInsightPro.repository;


import com.ankur_karna.CustomerInsightPro.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
