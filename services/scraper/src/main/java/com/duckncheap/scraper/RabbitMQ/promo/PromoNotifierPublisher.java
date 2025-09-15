package com.duckncheap.scraper.RabbitMQ.promo;

import com.duckncheap.shared.rabbitmq.PromoInfoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromoNotifierPublisher {
    private final RabbitTemplate rabbitTemplate;

    public void sendPromoNotifierMessage(PromoInfoMessage message) {
        rabbitTemplate.convertAndSend("promo.notifier.StoN", message);
    }
}
