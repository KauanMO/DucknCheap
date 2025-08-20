package com.duckncheap.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PromoInfoMessage {
    private Long chatId;
    private Double price;
    private ProductInfoMessage productInfo;
}
