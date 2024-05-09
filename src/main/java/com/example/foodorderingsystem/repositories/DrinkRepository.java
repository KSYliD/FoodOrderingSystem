package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Drink;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    @NotNull
    Drink save(@NotNull Drink drink);
    Drink findById(long id);
    Drink findByName(String name);
    void delete(@NotNull Drink drink);
    boolean existsByName(String name);
}
