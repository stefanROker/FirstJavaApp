package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
