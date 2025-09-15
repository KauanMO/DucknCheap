package com.duckncheap.notifier.service;

import com.duckncheap.notifier.repository.UserRepository;
import com.duckncheap.shared.exception.UserNotFoundException;
import com.duckncheap.shared.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserService {
    private final UserRepository repository;

    public User updateUserChatId(Object userFinder, Long chatId) {
        User userFound;

        if (userFinder instanceof String s) {
            try {
                Long userId = Long.parseLong(s);
                userFound = repository.findById(userId).orElseThrow(UserNotFoundException::new);
            } catch (NumberFormatException e) {
                userFound = repository.findByEmail(s).orElseThrow(UserNotFoundException::new);
            }
        } else if (userFinder instanceof Long id) {
            userFound = repository.findById(id).orElseThrow(UserNotFoundException::new);
        } else {
            throw new UserNotFoundException();
        }

        userFound.setChatId(chatId);

        return repository.save(userFound);
    }
}
