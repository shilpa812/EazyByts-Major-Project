package com.fitness.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.entity.DietPlan;

public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
}
