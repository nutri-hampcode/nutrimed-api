package com.ayrtonto.nutriapi.repository;

import com.ayrtonto.nutriapi.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
