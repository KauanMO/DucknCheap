package com.DucknCheap.service.promo;

import com.DucknCheap.dto.CreatePromoDTO;
import com.duckncheap.model.Product;
import com.duckncheap.model.Promo;
import com.duckncheap.service.crud.CreateEntity;

import java.util.List;

public interface PromoService extends CreateEntity<Promo, CreatePromoDTO> {
    void deactivePromos(List<Long> ids);
    List<Promo> getActivePromosByProduct(Product product);
}
