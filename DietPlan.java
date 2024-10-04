package com.fitness.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String mealType; // e.g., "Breakfast", "Lunch", "Dinner"
    private int calories;

    // Add more fields if required
}

