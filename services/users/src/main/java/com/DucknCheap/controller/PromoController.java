package com.DucknCheap.controller;

import com.DucknCheap.dto.promo.OutPromoDTO;
import com.DucknCheap.security.SecurityUtils;
import com.DucknCheap.service.promo.PromoService;
import com.duckncheap.model.Promo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
