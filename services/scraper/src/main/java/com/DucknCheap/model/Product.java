package com.DucknCheap.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
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

    private LocalDate createdAt;

    @OneToMany(mappedBy = "product")
    private List<Promo> promos;

    @ManyToOne
    private User user;
}
