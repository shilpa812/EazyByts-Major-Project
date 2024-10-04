package com.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fitness.entity.Booking;
import com.fitness.service.BookingService;
import com.fitness.service.DietPlanService;
import com.fitness.service.UserService;
import com.fitness.service.WorkoutService;

import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private DietPlanService dietPlanService;

    @GetMapping
    public String listBookings(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "list";
    }

    @GetMapping("/add")
    public String showBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("workouts", workoutService.getAllWorkouts());
        model.addAttribute("dietPlans", dietPlanService.getAllDietPlans());
        return "add";
    }

    @PostMapping
    public String saveBooking(@ModelAttribute("booking") Booking booking) {
        bookingService.saveBooking(booking);
        return "redirect:/bookings";
    }

    @GetMapping("/edit/{id}")
    public String editBookingForm(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBookingById(id).orElse(null);
        model.addAttribute("booking", booking);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("workouts", workoutService.getAllWorkouts());
        model.addAttribute("dietPlans", dietPlanService.getAllDietPlans());
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateBooking(@PathVariable Long id, @ModelAttribute("booking") Booking booking) {
        booking.setId(id);
        bookingService.saveBooking(booking);
        return "redirect:/bookings";
    }

    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.getBookingById(id).ifPresent(bookingService::deleteBooking);
        return "redirect:/bookings";
    }
}

