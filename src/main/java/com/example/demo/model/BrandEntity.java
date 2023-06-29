package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand")
@Getter
@Setter
@NoArgsConstructor
public class BrandEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "logo", nullable = false)
    private String logo;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "brand")
    private List<ProductEntity> products = new ArrayList<>();
}