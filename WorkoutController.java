package com.fitness.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fitness.entity.Workout;
import com.fitness.service.WorkoutService;

import java.util.List;

@Controller
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    // Display all workouts
    @GetMapping
    public String listWorkouts(Model model) {
        List<Workout> workouts = workoutService.getAllWorkouts();
        model.addAttribute("workouts", workouts);
        return "workouts"; // Path to the list page
    }

    // Show the form to add a new workout
    @GetMapping("/add")
    public String showAddWorkoutForm(Model model) {
        model.addAttribute("workout", new Workout());
        return "workouts/add"; // Path to the add page
    }

    // Handle the form submission to save a new workout
    @PostMapping
    public String saveWorkout(@ModelAttribute("workout") Workout workout) {
        workoutService.saveWorkout(workout);
        return "redirect:/workouts";
    }

    // Show the form to edit an existing workout
    @GetMapping("/edit/{id}")
    public String showEditWorkoutForm(@PathVariable Long id, Model model) {
        Workout workout = workoutService.getWorkoutById(id);
        model.addAttribute("workout", workout);
        return "workouts/edit"; // Path to the edit page
    }

    // Handle the form submission to update a workout
    @PostMapping("/update/{id}")
    public String updateWorkout(@PathVariable Long id, @ModelAttribute("workout") Workout workout) {
        // Get existing workout from the database
        Workout existingWorkout = workoutService.getWorkoutById(id);
        
        // Update fields
        existingWorkout.setName(workout.getName());
        existingWorkout.setDescription(workout.getDescription());
        existingWorkout.setDuration(workout.getDuration());
        existingWorkout.setIntensity(workout.getIntensity());

        // Save updated workout
        workoutService.saveWorkout(existingWorkout);
        return "redirect:/workouts";
    }

    // Delete a workout
    @GetMapping("/delete/{id}")
    public String deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkoutById(id);
        return "redirect:/workouts";
    }
}
