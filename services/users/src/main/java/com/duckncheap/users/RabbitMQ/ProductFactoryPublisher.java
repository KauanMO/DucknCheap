package com.duckncheap.users.RabbitMQ;

import com.duckncheap.shared.rabbitmq.ProductScrapMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFactoryPublisher {
    private final RabbitTemplate rabbitTemplate;

    public void sendCreateMessage(ProductScrapMessage message) {
        rabbitTemplate.convertAndSend("products.factory.UtoS", message);
    }
}
