package com.DucknCheap.service;

import com.duckncheap.exception.UserNotFoundException;
import com.duckncheap.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramWebhookService extends TelegramWebhookBot {
    private final UpdateUserService updateUserService;
    private final String botToken;

    public TelegramWebhookService(UpdateUserService updateUserService,
                                  @Value("${telegram.token}") String botToken) {
        this.updateUserService = updateUserService;
        this.botToken = botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();

        SendMessage response = new SendMessage();
        response.setChatId(chatId);
        response.setText("Olá! 😊 pra começar a usar o DucknCheap, responda essa mensagem com esse modelo:\n\n/start <SEU ID/EMAIL NO SITE> ");

        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();

            if (text.startsWith("/start")) {
                String[] parts = text.split(" ");

                if (parts.length > 1) {
                    Object userFinder = parts[1];

                    try {
                        User userFound = updateUserService.updateUserChatId(userFinder, chatId);

                        response.setText(String.format(
                                "Olá, %s! 😊\n\nSeu chat foi registrado com sucesso, registre produtos no site e fique tranquilo que te avisarei quando chegar promoções! 🦆",
                                userFound.getEmail().split("@")[0]
                        ));
                    } catch (UserNotFoundException e) {
                        response.setText("Olá! não consegui te achar no sistema com esse id ou email 😓\n\nVerifique seu id ou email e tente denovo!");
                    }
                }
            }
        }

        return response;
    }

    @Override
    public String getBotPath() {
        return "duckncheap/webhook";
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return "duckncheap_bot";
    }
}
