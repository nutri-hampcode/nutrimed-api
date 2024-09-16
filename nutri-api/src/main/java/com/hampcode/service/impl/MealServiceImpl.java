package com.hampcode.service.impl;

import com.hampcode.model.entity.Meal;
import com.hampcode.model.repository.MealRepository;
import com.hampcode.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Override
    public List<Meal> findAllMeals() {
        return mealRepository.findAll();
    }

    @Override
    public Meal findMealById(Integer id) {
        return mealRepository.findById(id).orElseThrow(() -> new RuntimeException("Meal not found"));
    }
}
