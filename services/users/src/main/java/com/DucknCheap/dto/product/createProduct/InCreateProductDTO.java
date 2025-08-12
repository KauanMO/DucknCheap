package com.DucknCheap.dto.product.createProduct;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public record InCreateProductDTO(
        @URL
        @NotNull
        @NotBlank
        String url,
        String name,
        @NotNull
        @NotBlank
        String store
) {
}
