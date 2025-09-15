package com.duckncheap.users.service.product;

import com.duckncheap.users.RabbitMQ.ProductFactoryPublisher;
import com.duckncheap.users.dto.product.createProduct.InCreateProductDTO;
import com.duckncheap.shared.repository.ProductRepository;
import com.duckncheap.users.security.SecurityUtils;
import com.duckncheap.users.service.user.UserService;
import com.duckncheap.shared.model.Product;
import com.duckncheap.shared.model.User;
import com.duckncheap.shared.model.ValiableStoresEnum;
import com.duckncheap.shared.rabbitmq.ProductInfoMessage;
import com.duckncheap.shared.rabbitmq.ProductScrapMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Product create(ProductInfoMessage productInfoMessage) {
        User userFound = userService.getById(productInfoMessage.getUserId());

        Product newProduct = Product.builder()
                .name(productInfoMessage.getName())
                .price(productInfoMessage.getPrice())
                .description(productInfoMessage.getDescription())
                .active(true)
                .image(productInfoMessage.getImage())
                .store(productInfoMessage.getStore())
                .url(productInfoMessage.getUrl())
                .user(userFound)
                .build();

        return repository.save(newProduct);
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        return repository.findAll();
    }
}
