package com.DucknCheap.service.exceptions;

import com.DucknCheap.dto.ErrorDTO;
import com.duckncheap.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<ErrorDTO> exceptionHandler(EmailAlreadyUsedException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(status).body(new ErrorDTO(
                ex.getMessage(), LocalDateTime.now(), status.value()
        ));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> exceptionHandler(UserNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status).body(new ErrorDTO(
                ex.getMessage(), LocalDateTime.now(), status.value()
        ));
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ErrorDTO> exceptionHandler(IncorrectPasswordException ex) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(new ErrorDTO(
                ex.getMessage(), LocalDateTime.now(), status.value()
        ));
    }
}
