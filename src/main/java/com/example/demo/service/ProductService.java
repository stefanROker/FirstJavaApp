package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<ProductRepository, ProductEntity, Product> {
    public ProductService() {
        super(ProductEntity.class, Product.class);
    }

    @Override
    public void update(Long id, Product product) {
        ProductEntity productEntity = repository.findById(id).orElseThrow(exceptionSupplier.setId(id));

        productEntity.setTitle(product.getTitle());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setPrp(product.getPrp());
        productEntity.setSku(product.getSku());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setPromotionPrice(product.getPromotionPrice());

        repository.save(productEntity);
    }
}
