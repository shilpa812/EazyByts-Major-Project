package com.fitness.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String duration; // e.g., "30 minutes"
    private String intensity; // e.g., "Beginner", "Intermediate", "Advanced"

    // More fields can be added as necessary
}

