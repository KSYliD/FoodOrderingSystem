package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Cuisine;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
    @NotNull
    Cuisine save(@NotNull Cuisine cuisine);
    Cuisine findById(long id);
    Cuisine findByName(String name);
    void delete(@NotNull Cuisine cuisine);
    boolean existsByName(String name);

}
