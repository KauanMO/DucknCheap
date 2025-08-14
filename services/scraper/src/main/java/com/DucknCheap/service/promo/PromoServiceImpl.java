package com.DucknCheap.service.promo;

import com.DucknCheap.dto.CreatePromoDTO;
import com.DucknCheap.repository.PromoRepository;
import com.duckncheap.model.Product;
import com.duckncheap.model.Promo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromoServiceImpl implements PromoService {
    private final PromoRepository repository;

    @Override
    public Promo create(CreatePromoDTO createPromoDTO) {
        Promo promo = Promo.builder()
                .price(createPromoDTO.price())
                .active(true)
                .product(createPromoDTO.product())
                .build();

        return repository.save(promo);
    }

    @Override
    public void deactivePromos(List<Long> ids) {
        List<Promo> promosFound = repository.findAllByIdIn(ids);
        for (Promo promo : promosFound) {
            promo.setActive(false);
        }

        repository.saveAll(promosFound);
    }

    @Override
    public List<Promo> getActivePromosByProduct(Product product) {
        return product.getPromos().stream()
                .filter(Promo::getActive)
                .toList();
    }
}
