package com.hampcode.model.repository;

import com.hampcode.model.entity.MealNutritionalPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealNutritionalPlanRepository extends JpaRepository<MealNutritionalPlan, Integer> {
}
