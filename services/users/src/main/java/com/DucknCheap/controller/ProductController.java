package com.DucknCheap.controller;

import com.DucknCheap.dto.product.createProduct.InCreateProductDTO;
import com.DucknCheap.dto.product.createProduct.OutCreateProductDTO;
import com.DucknCheap.dto.product.getProduct.OutGetProductDTO;
import com.DucknCheap.service.product.ProductService;
import com.duckncheap.model.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
