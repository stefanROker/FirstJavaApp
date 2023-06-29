package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = {"id"}, allowGetters = true)
public class Brand {
    private Long id;

    @NotNull
    private String name;

    private String description = "";

    @NotNull
    private String logo = "storage/uploads/default_logo.jpg";
}
