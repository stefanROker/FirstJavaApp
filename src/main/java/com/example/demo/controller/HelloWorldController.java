package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.ProductEntity;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloWorldController {

    private ProductService productService;

    @GetMapping("/hello-user")
    public String helloUser() {
        return "Hello User!";
    }

    @GetMapping("/products")
    public Product helloAdmin() {
        return productService.getProduct();
    }
}
