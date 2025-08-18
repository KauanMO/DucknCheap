package com.duckncheap.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@Table(name="dnc_user")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private Long chatId;

    @Builder.Default
    private final LocalDate createdAt = LocalDate.now();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Product> products;
}
