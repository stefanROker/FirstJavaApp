package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
    private String firstName;
    private String lastName;
}
