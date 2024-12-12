package com.mani.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private BigDecimal price;

    @Column(nullable = false)
    private LocalDate createdDate;

    private String imageUrl;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
