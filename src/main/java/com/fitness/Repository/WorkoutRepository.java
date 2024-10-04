package com.fitness.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}


