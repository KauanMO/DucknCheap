package com.DucknCheap.dto.product.createProduct;

import java.time.LocalDateTime;

public record OutCreateProductDTO(
        String message,
        LocalDateTime timestamp
) {
    public OutCreateProductDTO() {
        this("Web Scraping initialized successfully", LocalDateTime.now());
    }
}
