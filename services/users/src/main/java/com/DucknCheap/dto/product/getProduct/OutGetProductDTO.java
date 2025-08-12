package com.DucknCheap.dto.product.getProduct;

import com.duckncheap.model.Product;

import java.time.LocalDate;

public record OutGetProductDTO(
        Long id,
        String name,
        String image,
        String description,
        String url,
        Double price,
        Boolean active,
        String store,
        LocalDate createdAt
) {
    public OutGetProductDTO(Product product) {
        this(product.getId(),
                product.getName(),
                product.getImage(),
                product.getDescription(),
                product.getUrl(),
                product.getPrice(),
                product.getActive(),
                product.getStore().name(),
                product.getCreatedAt());
    }
}
