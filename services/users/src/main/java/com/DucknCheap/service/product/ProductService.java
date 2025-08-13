package com.DucknCheap.service.product;

import com.DucknCheap.dto.product.createProduct.InCreateProductDTO;
import com.DucknCheap.service.crud.CreateEntity;
import com.DucknCheap.service.crud.GetAll;
import com.duckncheap.model.Product;
import com.duckncheap.rabbitmq.ProductInfo;

public interface ProductService extends
        CreateEntity<Product, ProductInfo>,
        GetAll<Product> {
    void sendScrapRequest(InCreateProductDTO inCreateProductDTO);
}
