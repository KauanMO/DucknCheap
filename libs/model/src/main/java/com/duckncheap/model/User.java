package com.duckncheap.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@Table(name="dnc_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;

    private final LocalDate createdAt = LocalDate.now();

    @OneToMany(mappedBy = "user")
    private List<Product> products;
}
