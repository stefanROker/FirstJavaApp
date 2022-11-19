package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Product {

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
