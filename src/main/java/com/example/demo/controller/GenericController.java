package com.example.demo.controller;

import com.example.demo.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

abstract public class GenericController<S extends ServiceInterface<M>, M> {
    @Autowired
    protected S service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody M model) {
        service.save(model);
    }

    @GetMapping("")
    public List<M> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public M get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody M model) {
        service.update(id, model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
