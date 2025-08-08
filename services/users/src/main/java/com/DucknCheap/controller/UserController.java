package com.DucknCheap.controller;

import com.DucknCheap.dto.user.InCreateUserDTO;
import com.DucknCheap.dto.user.OutCreateUserDTO;
import com.DucknCheap.service.user.UserService;
import com.duckncheap.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("users"))
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<OutCreateUserDTO> createUser(@RequestBody @Valid InCreateUserDTO dto) {
        User newUser = service.create(dto);

        return ResponseEntity.ok(new OutCreateUserDTO(newUser));
    }
}
