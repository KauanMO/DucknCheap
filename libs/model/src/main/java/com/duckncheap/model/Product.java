package com.duckncheap.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "dnc_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String image;
    private String description;
    private Double price;
    private Boolean active;

    private final LocalDate createdAt = LocalDate.now();

    @OneToMany(mappedBy = "product")
    private List<Promo> promos;

    @ManyToOne
    private User user;
}
