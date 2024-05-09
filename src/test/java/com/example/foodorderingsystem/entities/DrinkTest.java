package com.example.foodorderingsystem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DrinkTest {

    private Drink drink;

    @BeforeEach
    public void setUp() {
        drink = new Drink("Cola", 2.99, "Classic carbonated beverage");
    }

    @Test
    public void testConstructorAndGetter() {
        assertEquals("Cola", drink.getName());
        assertEquals(2.99, drink.getPrice());
        assertEquals("Classic carbonated beverage", drink.getDetails());
    }

    @Test
    public void testSetter() {
        drink.setName("Lemonade");
        drink.setPrice(3.49);
        drink.setDetails("Refreshing citrus drink");

        assertEquals("Lemonade", drink.getName());
        assertEquals(3.49, drink.getPrice());
        assertEquals("Refreshing citrus drink", drink.getDetails());
    }

}
