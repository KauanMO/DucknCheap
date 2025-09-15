package com.duckncheap.users.dto.user.createUser;

import com.duckncheap.shared.model.User;

public record OutCreateUserDTO(
        Long id,
        String email
) {
    public OutCreateUserDTO(User user) {
        this(user.getId(), user.getEmail());
    }
}
