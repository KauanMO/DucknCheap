package com.duckncheap.scraper.service.promo;

import com.duckncheap.scraper.dto.CreatePromoDTO;
import com.duckncheap.shared.model.Product;
import com.duckncheap.shared.model.Promo;
import com.duckncheap.shared.crud.CreateEntity;

import java.util.List;

public interface PromoService extends CreateEntity<Promo, CreatePromoDTO> {
    void deactivePromos(List<Long> ids);
    List<Promo> getActivePromosByProduct(Product product);
}
