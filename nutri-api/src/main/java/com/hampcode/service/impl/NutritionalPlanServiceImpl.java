package com.hampcode.service.impl;

import com.hampcode.model.entity.NutritionalPlan;
import com.hampcode.model.repository.NutritionalPlanRepository;
import com.hampcode.service.NutritionalPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NutritionalPlanServiceImpl implements NutritionalPlanService {

    @Autowired
    private NutritionalPlanRepository nutritionalPlanRepository;

    @Override
    public List<NutritionalPlan> findAllNutritionalPlans() {
        return nutritionalPlanRepository.findAll();
    }

    @Override
    public NutritionalPlan findNutritionalPlanById(Integer id) {
        return nutritionalPlanRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutritional plan not found"));
    }
}
