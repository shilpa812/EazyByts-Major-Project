package com.fitness.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role; // e.g., ROLE_USER, ROLE_ADMIN

    // Other user-related fields can be added as needed
}

