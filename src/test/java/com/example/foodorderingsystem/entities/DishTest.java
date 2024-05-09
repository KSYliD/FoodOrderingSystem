package com.example.foodorderingsystem.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DishTest {

    @Test
    public void testConstructorWithCuisine() {
        Cuisine cuisine = new Cuisine("Italian");
        Dish dish = new Dish("Pizza", 9.99, "Delicious Italian pizza", cuisine);

        assertEquals("Pizza", dish.getName());
        assertEquals(9.99, dish.getPrice());
        assertEquals("Delicious Italian pizza", dish.getDetails());
        assertEquals(cuisine, dish.getCuisine());
    }

    @Test
    public void testConstructorWithoutCuisine() {
        Dish dish = new Dish("Sushi", 12.99, "Fresh Japanese sushi");

        assertEquals("Sushi", dish.getName());
        assertEquals(12.99, dish.getPrice());
        assertEquals("Fresh Japanese sushi", dish.getDetails());
        assertNull(dish.getCuisine());
    }

    @Test
    public void testSettersAndGetters() {
        Cuisine cuisine = new Cuisine("Japanese");
        Dish dish = new Dish();

        dish.setId(1L);
        dish.setName("Sushi");
        dish.setPrice(12.99);
        dish.setDetails("Fresh Japanese sushi");
        dish.setCuisine(cuisine);

        assertEquals(1L, dish.getId());
        assertEquals("Sushi", dish.getName());
        assertEquals(12.99, dish.getPrice());
        assertEquals("Fresh Japanese sushi", dish.getDetails());
        assertEquals(cuisine, dish.getCuisine());
    }
}
