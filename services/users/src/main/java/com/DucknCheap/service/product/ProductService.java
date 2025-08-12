package com.DucknCheap.service.product;

import com.DucknCheap.dto.product.createProduct.InCreateProductDTO;

public interface ProductService {
    void sendScrapRequest(InCreateProductDTO inCreateProductDTO);
}
