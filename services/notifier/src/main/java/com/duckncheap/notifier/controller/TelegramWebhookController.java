package com.duckncheap.notifier.controller;

import com.duckncheap.notifier.service.TelegramWebhookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequestMapping("duckncheap/webhook")
@RequiredArgsConstructor
public class TelegramWebhookController {
    private final TelegramWebhookService service;

    @PostMapping
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return service.onWebhookUpdateReceived(update);
    }
}
