package com.example.foodorderingsystem.datasetup;


import com.example.foodorderingsystem.entities.Order;
import com.example.foodorderingsystem.repositories.*;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OrderLoader implements ApplicationListener<ContextRefreshedEvent> {
    private OrderRepository orderRepository;
    private DishRepository dishRepository;
    private DessertRepository dessertRepository;
    private DrinkRepository drinkRepository;

    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        createOrders();
    }
    public void createOrders() {
        orderRepository.saveAll(getOrders());


    }
    private List<Order> getOrders(){
        return List.of(
                new Order(4,
                        dishRepository.findByName("Bigos"),
                        dessertRepository.findByName("Charlotte"),
                        drinkRepository.findByName("mojito"),
                        ""),
                new Order(2,
                        dishRepository.findByName("Mole"),
                        dessertRepository.findByName("Churos"),
                        drinkRepository.findByName("tea"),
                        ""),
                new Order(5,
                        dishRepository.findByName("Arancini"),
                        dessertRepository.findByName("Capirotada"),
                        drinkRepository.findByName("wine"),
                        "nuts allergy"));

    }
}
