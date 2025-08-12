package com.DucknCheap.service.product;

import com.duckncheap.rabbitmq.ProductScrapMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductScrapPublisher {
    private final RabbitTemplate rabbitTemplate;

    public void sendCreateMessage(ProductScrapMessage message) {
        rabbitTemplate.convertAndSend("products.factory", message);
    }
}
