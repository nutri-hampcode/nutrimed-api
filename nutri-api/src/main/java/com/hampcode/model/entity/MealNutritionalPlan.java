package com.hampcode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "meal_nutritional_plan")
public class MealNutritionalPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_nutritional_plan", nullable = false)
    private NutritionalPlan nutritionalPlan;

    @ManyToOne
    @JoinColumn(name = "id_meal", nullable = false)
    private Meal meal;
}
