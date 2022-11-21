package com.example.demo.service;

import java.util.List;

public interface ServiceInterface<T> {
    void save(T model);
    T get(Long id);
    List<T> getAll();
    void update(Long id, T model);
    void delete(Long id);
}
