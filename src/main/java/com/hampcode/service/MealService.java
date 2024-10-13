package com.hampcode.service;

import com.hampcode.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hampcode.model.entity.Meal;
import com.hampcode.model.entity.MealDTO;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    // Método para crear una nueva comida usando MealDTO
    public Meal createMeal(MealDTO mealDto) {
        Meal meal = convertToEntity(mealDto); // Convertir DTO a entidad Meal
        return mealRepository.save(meal); // Devuelve la entidad guardada
    }

    // Método para obtener todas las comidas
    public List<Meal> findAllMeals() {
        return mealRepository.findAll();
    }

    // Método para obtener una comida por ID
    public Meal findMealById(Integer id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Comida no encontrada con ID: " + id));
    }

    // Método para actualizar una comida existente usando MealDTO
    public Meal updateMeal(Integer id, MealDTO mealDto) {
        Meal existingMeal = findMealById(id); // Llama al método para obtener la comida
        existingMeal.setName(mealDto.getName());
        existingMeal.setDescription(mealDto.getDescription());
        existingMeal.setProteins(mealDto.getProteins());
        existingMeal.setCarbs(mealDto.getCarbs());
        existingMeal.setFat(mealDto.getFat());

        return mealRepository.save(existingMeal); // Devuelve la comida actualizada
    }

    // Método para eliminar una comida
    public void deleteMeal(Integer id) {
        Meal existingMeal = findMealById(id); // Verifica si la comida existe
        mealRepository.delete(existingMeal); // Elimina la comida
    }

    // Método público para convertir una entidad Meal a MealDTO
    public MealDTO convertToDTO(Meal meal) {
        MealDTO dto = new MealDTO();
        dto.setName(meal.getName());
        dto.setDescription(meal.getDescription());
        dto.setProteins(meal.getProteins());
        dto.setCarbs(meal.getCarbs());
        dto.setFat(meal.getFat());
        return dto;
    }

    // Método público para convertir un MealDTO a una entidad Meal
    public Meal convertToEntity(MealDTO mealDto) {
        Meal meal = new Meal();
        meal.setName(mealDto.getName());
        meal.setDescription(mealDto.getDescription());
        meal.setProteins(mealDto.getProteins());
        meal.setCarbs(mealDto.getCarbs());
        meal.setFat(mealDto.getFat());
        return meal;
    }
}