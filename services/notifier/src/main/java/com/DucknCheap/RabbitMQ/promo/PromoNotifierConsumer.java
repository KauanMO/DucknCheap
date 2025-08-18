package com.DucknCheap.RabbitMQ.promo;

import com.DucknCheap.service.PromoBotService;
import com.duckncheap.rabbitmq.PromoInfoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromoNotifierConsumer {
    private final PromoBotService service;

    @RabbitListener(queues = "promo.notifier.StoN")
    public void consume(PromoInfoMessage promoMessage) {
        service.sendPromo(promoMessage);
    }
}
