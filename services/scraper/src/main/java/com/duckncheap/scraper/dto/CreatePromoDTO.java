package com.duckncheap.scraper.dto;

import com.duckncheap.shared.model.Product;

public record CreatePromoDTO(
        Product product,
        Double price
) {
}
