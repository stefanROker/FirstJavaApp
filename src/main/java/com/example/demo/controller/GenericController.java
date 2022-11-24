package com.example.demo.controller;

import com.example.demo.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GenericController<T> {
    @Autowired
    protected ServiceInterface<T> service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody T model) {
        service.save(model);
    }

    @GetMapping("")
    public List<T> getAllProducts() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public T getProduct(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable Long id, @RequestBody T model) {
        service.update(id, model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        service.delete(id);
    }
}
