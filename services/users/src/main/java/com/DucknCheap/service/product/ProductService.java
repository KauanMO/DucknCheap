package com.DucknCheap.service.product;

import com.DucknCheap.dto.product.createProduct.InCreateProductDTO;
import com.duckncheap.service.crud.CreateEntity;
import com.duckncheap.service.crud.GetAll;
import com.duckncheap.model.Product;
import com.duckncheap.rabbitmq.ProductInfoMessage;

public interface ProductService extends
        CreateEntity<Product, ProductInfoMessage>,
        GetAll<Product> {
    void sendScrapRequest(InCreateProductDTO inCreateProductDTO);
}
