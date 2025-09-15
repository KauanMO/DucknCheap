package com.duckncheap.notifier.service;

import com.duckncheap.shared.rabbitmq.PromoInfoMessage;
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
                "🔥 Promoção para o item: <b>%s</b>!!\nDE <s>R$%.2f</s> \nPOR R$%.2f\n\n<a href=\"%s\">Ver produto</a>",
                promoMessage.getProductInfo().getName(),
                promoMessage.getProductInfo().getPrice(),
                promoMessage.getPrice(),
                promoMessage.getProductInfo().getUrl()
        );

        SendMessage sendMessage = new SendMessage(
                promoMessage.getChatId().toString(),
                message
        );
        sendMessage.setParseMode("HTML");

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }
}
