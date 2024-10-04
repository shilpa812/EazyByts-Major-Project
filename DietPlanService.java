package com.fitness.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.Repository.DietPlanRepository;
import com.fitness.entity.Booking;
import com.fitness.entity.DietPlan;

import java.util.List;
import java.util.Optional;

@Service
public class DietPlanService {
    @Autowired
    private DietPlanRepository dietPlanRepository;

    public DietPlan saveDietPlan(DietPlan dietPlan) {
        return dietPlanRepository.save(dietPlan);
    }

    public List<DietPlan> getAllDietPlans() {
        return dietPlanRepository.findAll();
    }

    public Optional<DietPlan> getDietPlanById(Long id) {
        return dietPlanRepository.findById(id);
    }
    public void deleteDietPlan(DietPlan dietPlan) {
       dietPlanRepository.delete(dietPlan);
    }
}

