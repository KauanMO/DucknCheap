package com.DucknCheap.dto;

import com.duckncheap.model.Product;

public record CreatePromoDTO(
        Product product,
        Double price
) {
}
