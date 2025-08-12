package com.DucknCheap.RabbitMQ;

import com.duckncheap.rabbitmq.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductInfoPublisher {
    private final RabbitTemplate rabbitTemplate;

    public void sendProductInfoMessage(ProductInfo message) {
        rabbitTemplate.convertAndSend("products.factory.StoU", message);
    }
}
