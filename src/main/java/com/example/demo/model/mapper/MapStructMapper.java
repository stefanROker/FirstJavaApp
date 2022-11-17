package com.example.demo.model.mapper;

import com.example.demo.model.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    Product productEntityToProduct(ProductEntity productEntity);
    ProductEntity productToProductEntity(Product product);

    Brand brandEntityToBrand(BrandEntity brandEntity);
    BrandEntity brandToBrandEntity(Brand brand);

    Image productImageEntityToImage(ProductImageEntity productImageEntity);
    ProductImageEntity imageToProductImageEntity(Image image);
}
