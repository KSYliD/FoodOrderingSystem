package com.example.foodorderingsystem.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DessertTest {

    @Test
    public void testConstructorWithCuisine() {
        Cuisine cuisine = new Cuisine("Italian");
        Dessert dessert = new Dessert("Tiramisu", 5.99, "Classic Italian dessert", cuisine);

        assertEquals("Tiramisu", dessert.getName());
        assertEquals(5.99, dessert.getPrice());
        assertEquals("Classic Italian dessert", dessert.getDetails());
        assertEquals(cuisine, dessert.getCuisine());
    }

    @Test
    public void testConstructorWithoutCuisine() {
        Dessert dessert = new Dessert("Cheesecake", 4.99, "Creamy and delicious");

        assertEquals("Cheesecake", dessert.getName());
        assertEquals(4.99, dessert.getPrice());
        assertEquals("Creamy and delicious", dessert.getDetails());
        assertNull(dessert.getCuisine());
    }

    @Test
    public void testSettersAndGetters() {
        Cuisine cuisine = new Cuisine("Italian");
        Dessert dessert = new Dessert();

        dessert.setId(1L);
        dessert.setName("Tiramisu");
        dessert.setPrice(5.99);
        dessert.setDetails("Classic Italian dessert");
        dessert.setCuisine(cuisine);

        assertEquals(1L, dessert.getId());
        assertEquals("Tiramisu", dessert.getName());
        assertEquals(5.99, dessert.getPrice());
        assertEquals("Classic Italian dessert", dessert.getDetails());
        assertEquals(cuisine, dessert.getCuisine());
    }
}
