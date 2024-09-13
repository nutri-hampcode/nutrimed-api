package com.hampcode.service;

import com.hampcode.model.entity.Meal;
import com.hampcode.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public List<Meal> findAllMeals() {
        return mealRepository.findAll();
    }

    public Meal findMealById(Integer id) {
        return mealRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encuentra la comida"));
    }
}
