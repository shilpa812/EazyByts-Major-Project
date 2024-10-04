package com.fitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.Repository.WorkoutRepository;
import com.fitness.entity.Workout;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    // Retrieve all workouts
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    // Retrieve a workout by ID
    public Workout getWorkoutById(Long id) {
        Optional<Workout> optionalWorkout = workoutRepository.findById(id);
        return optionalWorkout.orElse(null);
    }

    // Save or update a workout
    public void saveWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    // Delete a workout by ID
    public void deleteWorkoutById(Long id) {
        workoutRepository.deleteById(id);
    }
}
