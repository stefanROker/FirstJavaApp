package com.example.demo.controller;

import com.example.demo.model.Brand;
import com.example.demo.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController extends GenericController<BrandService, Brand> {

//    @GetMapping("?name={name}")
//    public Brand getByName(@PathVariable String name) {
//        return service.getByName(name);
//    }
}
