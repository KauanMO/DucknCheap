package com.duckncheap.repository;

import com.duckncheap.model.Promo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromoRepository extends JpaRepository<Promo, Long> {
    List<Promo> findAllByIdIn(List<Long> id);

    List<Promo> findByProductUserId(Long userId);
}
