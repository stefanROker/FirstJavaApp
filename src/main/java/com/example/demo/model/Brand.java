package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class Brand {
    @NotNull
    private String name;

    private String description = "";
}
