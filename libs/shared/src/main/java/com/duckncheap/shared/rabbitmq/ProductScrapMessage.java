package com.duckncheap.shared.rabbitmq;

import com.duckncheap.shared.model.ValiableStoresEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductScrapMessage implements Serializable {
    private String productUrl;
    private Long userId;
    private String productName;
    private ValiableStoresEnum store;
}
