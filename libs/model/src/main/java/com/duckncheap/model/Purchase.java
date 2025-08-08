package com.duckncheap.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;

import java.time.LocalDate;

@Data
@Entity
@Builder
@Table(name="dnc_purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final LocalDate createdAt = LocalDate.now();

    @OneToOne
    private Promo promo;
}
