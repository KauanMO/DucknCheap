package com.DucknCheap.service.product;

import com.DucknCheap.dto.product.createProduct.InCreateProductDTO;
import com.DucknCheap.security.SecurityUtils;
import com.duckncheap.model.Product;
import com.duckncheap.rabbitmq.ProductScrapMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductScrapPublisher productScrapPublisher;

    @Override
    public void sendScrapRequest(InCreateProductDTO inCreateProductDTO) {
        productScrapPublisher.sendCreateMessage(
                new ProductScrapMessage(inCreateProductDTO.url(),
                        SecurityUtils.getUserId(),
                        inCreateProductDTO.name())
        );
    }
}
