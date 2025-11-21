package com.example.umc9th.domain.food.repository;

import com.example.umc9th.domain.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findById(Long id);
}
