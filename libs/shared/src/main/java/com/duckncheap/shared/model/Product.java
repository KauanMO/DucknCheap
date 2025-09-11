package com.duckncheap.shared.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dnc_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String image;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private Boolean active;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String url;
    private ValiableStoresEnum store;

    @Builder.Default
    private final LocalDate createdAt = LocalDate.now();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Promo> promos;

    @ManyToOne
    private User user;
}
