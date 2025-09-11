package com.duckncheap.shared.repository;

import com.duckncheap.shared.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getAllByUserId(Long userId);
}
