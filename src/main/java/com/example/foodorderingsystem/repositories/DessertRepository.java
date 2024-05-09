package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Dessert;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DessertRepository extends JpaRepository<Dessert, Long> {
    @NotNull
    Dessert save(@NotNull Dessert dessert);
    Dessert findById(long id);
    Dessert findByName(String name);
    void delete(@NotNull Dessert dessert);
    boolean existsByName(String name);
}