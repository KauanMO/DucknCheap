package com.duckncheap.users.dto.promo;

import com.duckncheap.users.dto.product.getProduct.OutGetProductDTO;
import com.duckncheap.shared.model.Promo;

public record OutPromoDTO(
        Long id,
        Double price,
        Boolean active,
        OutGetProductDTO product
) {
    public OutPromoDTO(Promo p) {
        this(p.getId(),
                p.getPrice(),
                p.getActive(),
                new OutGetProductDTO(p.getProduct()));
    }
}
