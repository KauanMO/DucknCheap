package com.DucknCheap.service.product;

import com.DucknCheap.RabbitMQ.ProductFactoryPublisher;
import com.DucknCheap.dto.product.createProduct.InCreateProductDTO;
import com.DucknCheap.repository.ProductRepository;
import com.DucknCheap.security.SecurityUtils;
import com.DucknCheap.service.user.UserService;
import com.duckncheap.model.Product;
import com.duckncheap.model.User;
import com.duckncheap.model.ValiableStoresEnum;
import com.duckncheap.rabbitmq.ProductInfo;
import com.duckncheap.rabbitmq.ProductScrapMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductFactoryPublisher productFactoryPublisher;
    private final ProductRepository repository;
    private final UserService userService;

    @Override
    public void sendScrapRequest(InCreateProductDTO inCreateProductDTO) {
        productFactoryPublisher.sendCreateMessage(
                new ProductScrapMessage(inCreateProductDTO.url(),
                        SecurityUtils.getUserId(),
                        inCreateProductDTO.name(),
                        ValiableStoresEnum.valueOf(inCreateProductDTO
                                .store()
                                .toUpperCase()))
        );
    }

    @Override
    public Product create(ProductInfo productInfo) {
        User userFound = userService.getById(productInfo.getUserId());

        Product newProduct = Product.builder()
                .name(productInfo.getName())
                .price(productInfo.getPrice())
                .description(productInfo.getDescription())
                .active(true)
                .image(productInfo.getImage())
                .store(productInfo.getStore())
                .url(productInfo.getUrl())
                .user(userFound)
                .build();

        return repository.save(newProduct);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }
}
