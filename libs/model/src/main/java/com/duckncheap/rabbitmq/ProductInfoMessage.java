package com.duckncheap.rabbitmq;

import com.duckncheap.model.Product;
import com.duckncheap.model.ValiableStoresEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ProductInfoMessage {
    private String url;
    private Long userId;
    private String name;
    private ValiableStoresEnum store;
    private String image;
    private String description;
    private Double price;

    public ProductInfoMessage(Product product) {
        this.url = product.getUrl();
        this.userId = product.getUser().getId();
        this.name = product.getName();
        this.store = product.getStore();
        this.image = product.getImage();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}
