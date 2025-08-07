package com.DucknCheap.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="dnc_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;

    private LocalDate createdAt;

    @OneToMany(mappedBy = "user")
    private List<Product> products;
}
