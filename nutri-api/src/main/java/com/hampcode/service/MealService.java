package com.hampcode.service;

import com.hampcode.model.entity.Meal;
import java.util.List;

public interface MealService {
    List<Meal> findAllMeals();
    Meal findMealById(Integer id);
}
