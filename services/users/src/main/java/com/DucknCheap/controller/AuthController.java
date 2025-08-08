package com.DucknCheap.controller;

import com.DucknCheap.dto.user.createUser.InCreateUserDTO;
import com.DucknCheap.dto.user.createUser.OutCreateUserDTO;
import com.DucknCheap.dto.user.login.InLoginDTO;
import com.DucknCheap.dto.user.login.OutLoginDTO;
import com.DucknCheap.security.JwtUtil;
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
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<OutCreateUserDTO> register(@RequestBody @Valid InCreateUserDTO dto) {
        User newUser = userService.create(dto);

        return ResponseEntity.ok(new OutCreateUserDTO(newUser));
    }

    @PostMapping("/login")
    public ResponseEntity<OutLoginDTO> login(@RequestBody @Valid InLoginDTO dto) {
        User userFound = userService.login(dto);

        String token = jwtUtil.generateToken(userFound);

        return ResponseEntity.ok(new OutLoginDTO(userFound, token));
    }
}
