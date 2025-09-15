package com.duckncheap.scraper.service.product;

import com.duckncheap.shared.model.Product;
import com.duckncheap.shared.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }
}
