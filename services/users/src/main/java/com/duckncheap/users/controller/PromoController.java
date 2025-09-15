package com.duckncheap.users.controller;

import com.duckncheap.users.dto.promo.OutPromoDTO;
import com.duckncheap.users.security.SecurityUtils;
import com.duckncheap.users.service.promo.PromoService;
import com.duckncheap.shared.model.Promo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("promos")
@RequiredArgsConstructor
public class PromoController {
    private final PromoService service;

    @GetMapping
    public ResponseEntity<List<OutPromoDTO>> getAllByUserId() {
        Long userId = SecurityUtils.getUserId();

        List<Promo> promos = service.getAllByUserId(userId);

        return ResponseEntity
                .ok(promos.stream()
                        .map(OutPromoDTO::new)
                        .toList());
    }
}
