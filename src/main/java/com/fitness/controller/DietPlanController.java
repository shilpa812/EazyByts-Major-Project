package com.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fitness.entity.DietPlan;
import com.fitness.service.DietPlanService;

import java.util.List;

@Controller
@RequestMapping("/diet-plans")
public class DietPlanController {

    @Autowired
    private DietPlanService dietPlanService;

    @GetMapping
    public String listDietPlans(Model model) {
        List<DietPlan> dietPlans = dietPlanService.getAllDietPlans();
        model.addAttribute("dietPlans", dietPlans);
        return "dietPlans";
    }

    @GetMapping("/add")
    public String showAddDietPlanForm(Model model) {
        model.addAttribute("dietPlan", new DietPlan());
        return "add";
    }

    @PostMapping
    public String saveDietPlan(@ModelAttribute("dietPlan") DietPlan dietPlan) {
        dietPlanService.saveDietPlan(dietPlan);
        return "redirect:/diet-plans";
    }

    @GetMapping("/edit/{id}")
    public String showEditDietPlanForm(@PathVariable Long id, Model model) {
        DietPlan dietPlan = dietPlanService.getDietPlanById(id).orElse(null);
        model.addAttribute("dietPlan", dietPlan);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateDietPlan(@PathVariable Long id, @ModelAttribute("dietPlan") DietPlan dietPlan) {
        dietPlan.setId(id);
        dietPlanService.saveDietPlan(dietPlan);
        return "redirect:/diet-plans";
    }

    @GetMapping("/delete/{id}")
    public String deleteDietPlan(@PathVariable Long id) {
        dietPlanService.getDietPlanById(id).ifPresent(dietPlanService::deleteDietPlan);
        return "redirect:/diet-plans";
    }
}
