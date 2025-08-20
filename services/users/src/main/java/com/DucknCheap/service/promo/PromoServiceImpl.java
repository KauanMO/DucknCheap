package com.DucknCheap.service.promo;

import com.duckncheap.model.Promo;
import com.duckncheap.repository.PromoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromoServiceImpl implements PromoService {
    private final PromoRepository repository;

    @Override
    @Transactional
    public List<Promo> getAllByUserId(Long userId) {
        return repository.findByProductUserId(userId);
    }
}
