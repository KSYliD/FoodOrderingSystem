package com.example.foodorderingsystem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Order order;
    private Dish mainCourse;
    private Dessert dessert;
    private Drink drink;

    @BeforeEach
    public void setUp() {
        mainCourse = new Dish("Spaghetti Carbonara", 14.99, "Creamy pasta with bacon and cheese", new Cuisine("Italian"));
        dessert = new Dessert("Tiramisu", 8.99, "Classic Italian dessert", new Cuisine("Italian"));
        drink = new Drink("Cola", 2.99, "Classic carbonated beverage");
        order = new Order(1, mainCourse, dessert, drink, "No special requests");
    }

    @Test
    public void testConstructorAndGetter() {
        assertEquals(1, order.getTableNum());
        assertEquals(mainCourse, order.getMainCourse());
        assertEquals(dessert, order.getDessert());
        assertEquals(drink, order.getDrink());
        assertEquals("No special requests", order.getDetails());
    }

    @Test
    public void testSetter() {
        Drink newDrink = new Drink("Lemonade", 3.49, "Refreshing citrus drink");
        order.setDrink(newDrink);
        order.setTableNum(2);
        order.setMainCourse(new Dish("Chicken Alfredo", 16.99, "Creamy pasta with grilled chicken", new Cuisine("Italian")));
        order.setDessert(new Dessert("Cheesecake", 7.99, "Creamy dessert with a graham cracker crust", new Cuisine("American")));
        order.setDetails("Extra napkins please");

        assertEquals(2, order.getTableNum());
        assertEquals(newDrink, order.getDrink());
        assertEquals("Extra napkins please", order.getDetails());
        assertEquals("Chicken Alfredo", order.getMainCourse().getName());
        assertEquals("Cheesecake", order.getDessert().getName());
    }
}
