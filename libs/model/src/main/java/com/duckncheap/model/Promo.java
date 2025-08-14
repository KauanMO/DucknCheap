package com.duckncheap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dnc_promo")
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double price;
    private Boolean active;

    @Builder.Default
    private final LocalDate createdAt = LocalDate.now();

    @ManyToOne
    private Product product;
}
