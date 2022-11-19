package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductEntity;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public void saveProduct(Product product) {
        product.setId(0L);
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        productRepository.save(productEntity);
    }

    public Product getProduct(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        return productEntity.isPresent() ? modelMapper.map(productEntity, Product.class) : null;
    }

    public List<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities
                .stream()
                .map(entity -> modelMapper.map(entity, Product.class))
                .collect(Collectors.toList());
    }

    public boolean updateProduct(Product product) {
        try {
            ProductEntity productEntity = productRepository.getReferenceById(product.getId());

            productEntity.setTitle(product.getTitle());
            productEntity.setDescription(product.getDescription());
            productEntity.setPrice(product.getPrice());
            productEntity.setPrp(product.getPrp());
            productEntity.setSku(product.getSku());
            productEntity.setQuantity(product.getQuantity());
            productEntity.setPromotionPrice(product.getPromotionPrice());

            productRepository.save(productEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
