package com.DucknCheap.dto.user.createUser;

import com.duckncheap.model.User;

public record OutCreateUserDTO(
        Long id,
        String email
) {
    public OutCreateUserDTO(User user) {
        this(user.getId(), user.getEmail());
    }
}
