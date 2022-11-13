package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public Product getProduct() {
//        ProductEntity product = new ProductEntity(0L, "Stefan", "Chelbosu");
//        productRepository.save(product);
        ObjectMapper objectMapper;
        ProductEntity productEntity = productRepository.findProductByLastName("Chelbosu").get();
        Product product1 = Product.builder()
                .name(productEntity.getFirstName())
                .lastName(productEntity.getLastName())
                .build();
        return product1;
    }
}
