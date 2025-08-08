package com.DucknCheap.dto;

import java.time.LocalDateTime;

public record ErrorDTO(String message, LocalDateTime timestamp, Integer status) {
}
