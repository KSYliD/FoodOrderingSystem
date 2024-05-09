package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Order;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @NotNull
    Order save(@NotNull Order order);
    Order findById(long id);
    void delete(@NotNull Order order);
}
