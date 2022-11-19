package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundExceptionSupplier;
import com.example.demo.model.Product;
import com.example.demo.model.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final EntityNotFoundExceptionSupplier exceptionSupplier = new EntityNotFoundExceptionSupplier("Product");

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public void saveProduct(Product product) {
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        productRepository.save(productEntity);
    }

    public Product getProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(exceptionSupplier.setId(id));
        return modelMapper.map(productEntity, Product.class);
    }

    public List<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities
                .stream()
                .map(entity -> modelMapper.map(entity, Product.class))
                .collect(Collectors.toList());
    }

    public void updateProduct(Long id, Product product) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(exceptionSupplier.setId(id));

        productEntity.setTitle(product.getTitle());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setPrp(product.getPrp());
        productEntity.setSku(product.getSku());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setPromotionPrice(product.getPromotionPrice());

        productRepository.save(productEntity);
    }

    public void deleteProduct(Long id) {
        // Map thrown exception to the one supplied by the exception supplier in order to be caught by the right
        // exception handler.
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw exceptionSupplier.setId(id).get();
        }
    }
}
