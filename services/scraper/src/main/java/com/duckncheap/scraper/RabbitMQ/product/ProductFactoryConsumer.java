package com.duckncheap.scraper.RabbitMQ.product;

import com.duckncheap.scraper.service.ProductScrapperService;
import com.duckncheap.shared.rabbitmq.ProductScrapMessage;
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
