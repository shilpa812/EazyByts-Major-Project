package com.fitness.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = true)
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "diet_plan_id", nullable = true)
    private DietPlan dietPlan;

    private String bookingDate;
    private String status; // e.g., "Pending", "Confirmed", "Cancelled"
}

