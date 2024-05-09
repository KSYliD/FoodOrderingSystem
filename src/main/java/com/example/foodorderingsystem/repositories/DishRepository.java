package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Meal, Long> {
}
