package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Product {

    @NotNull
    private Long id = 0L;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private Float price;

    private Float prp;

    private Float promotionPrice;

    @NotNull
    private Integer quantity = 0;

    private String sku;

    private Brand brand;

    private List<Image> images;
}
