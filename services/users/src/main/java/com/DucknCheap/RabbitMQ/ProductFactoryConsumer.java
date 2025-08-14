package com.DucknCheap.RabbitMQ;

import com.DucknCheap.service.product.ProductService;
import com.duckncheap.rabbitmq.ProductInfoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFactoryConsumer {
    private final ProductService service;

    @RabbitListener(queues = "products.factory.StoU")
    public void consume(ProductInfoMessage product) {
        service.create(product);
    }
}
