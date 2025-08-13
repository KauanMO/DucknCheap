package com.DucknCheap.controller;

import com.DucknCheap.dto.product.createProduct.InCreateProductDTO;
import com.DucknCheap.dto.product.createProduct.OutCreateProductDTO;
import com.DucknCheap.dto.product.getProduct.OutGetProductDTO;
import com.DucknCheap.service.product.ProductService;
import com.duckncheap.model.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<OutCreateProductDTO> createProduct(@Valid @RequestBody InCreateProductDTO dto) {
        service.sendScrapRequest(dto);

        return ResponseEntity.accepted().body(new OutCreateProductDTO());
    }

    @GetMapping
    public ResponseEntity<List<OutGetProductDTO>> getAllProducts() {
        List<Product> products = service.getAll();

        return ResponseEntity.ok(products.stream()
                .map(OutGetProductDTO::new)
                .toList());
    }
}
