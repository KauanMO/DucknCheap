package com.DucknCheap.dto.user.createUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record InCreateUserDTO(
        @NotNull
        @NotBlank
        @Email
        String email,
        @NotNull
        @Size(min = 6, max = 20)
        String password
) {
}
