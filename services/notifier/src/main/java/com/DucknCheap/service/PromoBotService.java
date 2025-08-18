package com.DucknCheap.service;

import com.duckncheap.rabbitmq.PromoInfoMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class PromoBotService extends DefaultAbsSender {
    private final String botToken;

    public PromoBotService(@Value("${telegram.token}") String botToken) {
        super(new DefaultBotOptions());
        this.botToken = botToken;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void sendPromo(PromoInfoMessage promoMessage) {
        String message = String.format(
                "Promoção para o item: %s !! \n R$ %.2f \n \n %s",
                promoMessage.getProductInfo().getName(),
                promoMessage.getProductInfo().getPrice(),
                promoMessage.getProductInfo().getUrl()
        );

        SendMessage sendMessage = new SendMessage(promoMessage.getChatId(), message);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println(e.getCause());
        }
    }
}
