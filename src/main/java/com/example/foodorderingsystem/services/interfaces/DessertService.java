package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DessertRepository extends JpaRepository<Dessert, Long> {
}