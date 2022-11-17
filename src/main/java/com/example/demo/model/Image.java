package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class Image {
    @NotNull
    private String path;
}
