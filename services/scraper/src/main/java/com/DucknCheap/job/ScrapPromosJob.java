package com.DucknCheap.job;

import com.DucknCheap.RabbitMQ.promo.PromoNotifierPublisher;
import com.DucknCheap.dto.CreatePromoDTO;
import com.DucknCheap.service.ProductScrapperService;
import com.DucknCheap.service.product.ProductService;
import com.DucknCheap.service.promo.PromoService;
import com.duckncheap.model.Product;
import com.duckncheap.model.Promo;
import com.duckncheap.rabbitmq.ProductInfoMessage;
import com.duckncheap.rabbitmq.PromoInfoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ScrapPromosJob {
    private final ProductService productService;
    private final PromoService promoService;
    private final ProductScrapperService scrapperService;
    private final PromoNotifierPublisher promoNotifierPublisher;

    @Scheduled(cron = "0 0 0/3 * * ?")
    public void execute() {
        productService.getAll().stream()
                .filter(Product::getActive)
                .forEach(this::processProduct);
    }

    private void processProduct(Product product) {
        Optional<Double> promoPrice = scrapperService.webScrapPromo(product.getUrl(), product.getStore());
        List<Promo> activePromos = promoService.getActivePromosByProduct(product);

        promoPrice.ifPresentOrElse(
                price -> handleNewPromo(product, price, activePromos),
                () -> deactivateActivePromos(activePromos)
        );
    }

    private void handleNewPromo(Product product, Double price, List<Promo> activePromos) {
        boolean alreadyExists = activePromos.stream()
                .anyMatch(p -> p.getPrice().equals(price) && p.getActive());

        if (!alreadyExists) {
            deactivateActivePromos(activePromos);
            promoService.create(new CreatePromoDTO(product, price));

            promoNotifierPublisher.sendPromoNotifierMessage(
                    new PromoInfoMessage(product.getUser().getChatId(),
                            price,
                            new ProductInfoMessage(product)));
        }
    }

    private void deactivateActivePromos(List<Promo> activePromos) {
        if (!activePromos.isEmpty()) {
            promoService.deactivePromos(activePromos.stream().map(Promo::getId).toList());
        }
    }
}
