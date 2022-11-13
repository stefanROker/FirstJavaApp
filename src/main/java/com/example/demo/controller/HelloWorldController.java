package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HelloWorldController {

    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity helloUser(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/product/{lastName}")
    public ResponseEntity<Product> helloAdmin(@PathVariable String lastName) {
        return new ResponseEntity<>(productService.getProduct(lastName), HttpStatus.OK);
    }
}
