package com.DucknCheap.dto.user.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record InLoginDTO(
        @NotNull
        @Email
        String email,
        @NotNull
        @NotBlank
        @Size(min = 6, max = 20)
        String password
) {
}
