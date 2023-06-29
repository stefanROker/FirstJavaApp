package com.example.demo.service;

import com.example.demo.model.Brand;
import com.example.demo.model.BrandEntity;
import com.example.demo.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends GenericService<BrandRepository, BrandEntity, Brand> {
    public BrandService() {
        super(BrandEntity.class, Brand.class);
    }

    @Override
    public void update(Long id, Brand brand) {
        BrandEntity brandEntity = repository.findById(id).orElseThrow(exceptionSupplier.setId(id));

        brandEntity.setName(brand.getName());
        brandEntity.setDescription(brand.getDescription());
        brandEntity.setLogo((brand.getLogo()));

        repository.save(brandEntity);
    }

    public Brand getByName(String name) {
        BrandEntity brandEntity = repository.findByName(name).orElseThrow();
        return modelMapper.map(brandEntity, Brand.class);
    }
}
