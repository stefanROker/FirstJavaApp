package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
// Do not deserialize the ID in requests
@JsonIgnoreProperties(value = {"id"}, allowGetters = true)
public class Product {

    private Long id;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private Float price;

    private Float prp;

    private Float promotionPrice;

    @NotNull
    private Integer quantity;

    private String sku;

    private Brand brand;

    private List<Image> images;
}
