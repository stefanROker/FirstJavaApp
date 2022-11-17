package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;


    public void saveProduct(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        productRepository.save(productEntity);
    }

    public Product getProduct(String lastName) {
//        ProductEntity productEntity = productRepository.findProductByLastName(lastName).get();
//        Product product1 = Product.builder()
//                .firstName(productEntity.getFirstName())
//                .lastName(productEntity.getLastName())
//                .build();
        return null;
    }
}
