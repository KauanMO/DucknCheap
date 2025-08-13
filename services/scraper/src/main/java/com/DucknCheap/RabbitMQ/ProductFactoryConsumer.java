package com.DucknCheap.RabbitMQ;

import com.DucknCheap.service.ProductScrapperService;
import com.duckncheap.rabbitmq.ProductScrapMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFactoryConsumer {
    private final ProductScrapperService productScrapperService;

    @RabbitListener(queues = "products.factory.UtoS")
    public void consume(ProductScrapMessage productMessage) {
        productScrapperService.WebScrapProduct(productMessage);
    }
}
