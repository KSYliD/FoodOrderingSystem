package com.example.foodorderingsystem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuisineTest {

    private Cuisine cuisine;

    @BeforeEach
    public void setUp() {
        cuisine = new Cuisine("Italian");
    }

    @Test
    public void testConstructorWithName() {
        assertEquals("Italian", cuisine.getName());
    }

    @Test
    public void testGetterAndSetterForName() {
        cuisine.setName("Japanese");
        assertEquals("Japanese", cuisine.getName());
    }

}
