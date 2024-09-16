package com.hampcode.service;

import com.hampcode.model.entity.NutritionalPlan;
import java.util.List;

public interface NutritionalPlanService {
    List<NutritionalPlan> findAllNutritionalPlans();
    NutritionalPlan findNutritionalPlanById(Integer id);
}
