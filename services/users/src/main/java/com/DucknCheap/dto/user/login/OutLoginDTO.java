package com.DucknCheap.dto.user.login;

import com.duckncheap.model.User;

public record OutLoginDTO(
        Long id,
        String email,
        String token
) {
    public OutLoginDTO(User user, String token) {
        this(user.getId(), user.getEmail(), token);
    }
}
