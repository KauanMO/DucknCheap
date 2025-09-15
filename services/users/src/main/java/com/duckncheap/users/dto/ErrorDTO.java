package com.duckncheap.users.dto;

import java.time.LocalDateTime;

public record ErrorDTO(String message, LocalDateTime timestamp, Integer status) {
}
