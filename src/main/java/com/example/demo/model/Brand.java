package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Brand {
    @NotNull
    private String name;

    private String description = "";
}
