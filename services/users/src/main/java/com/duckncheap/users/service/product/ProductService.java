package com.duckncheap.users.service.product;

import com.duckncheap.users.dto.product.createProduct.InCreateProductDTO;
import com.duckncheap.shared.crud.CreateEntity;
import com.duckncheap.shared.crud.GetAll;
import com.duckncheap.shared.model.Product;
import com.duckncheap.shared.rabbitmq.ProductInfoMessage;

public interface ProductService extends
        CreateEntity<Product, ProductInfoMessage>,
        GetAll<Product> {
    void sendScrapRequest(InCreateProductDTO inCreateProductDTO);
}
