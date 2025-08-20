package com.DucknCheap.dto.promo;

import com.DucknCheap.dto.product.getProduct.OutGetProductDTO;
import com.duckncheap.model.Promo;

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
