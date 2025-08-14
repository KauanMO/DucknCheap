package com.duckncheap.repository;

import com.duckncheap.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getAllByUserId(Long userId);
}
