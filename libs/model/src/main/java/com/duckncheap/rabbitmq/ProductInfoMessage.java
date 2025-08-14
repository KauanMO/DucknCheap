package com.duckncheap.rabbitmq;

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
}
