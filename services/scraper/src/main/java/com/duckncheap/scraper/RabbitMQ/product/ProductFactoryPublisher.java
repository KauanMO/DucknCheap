package com.duckncheap.scraper.RabbitMQ.product;

import com.duckncheap.shared.rabbitmq.ProductInfoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFactoryPublisher {
    private final RabbitTemplate rabbitTemplate;

    public void sendProductInfoMessage(ProductInfoMessage message) {
        rabbitTemplate.convertAndSend("products.factory.StoU", message);
    }
}
