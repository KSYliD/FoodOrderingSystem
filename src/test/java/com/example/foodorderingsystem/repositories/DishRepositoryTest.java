package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Dish;
import com.example.foodorderingsystem.services.implementations.DishServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DishRepositoryTest {

    @Mock
    private DishRepository dishRepository;

    @InjectMocks
    private DishServiceImpl dishService;

    @Test
    public void testFindByName() {
        Dish dish = new Dish("Spaghetti Carbonara", 14.99, "Creamy pasta with bacon and cheese", null);

        when(dishRepository.findByName("Spaghetti Carbonara")).thenReturn(dish);

        Dish result = dishService.findByName("Spaghetti Carbonara");

        assertNotNull(result);
        assertEquals("Spaghetti Carbonara", result.getName());
    }

    @Test
    public void testExistsByName() {
        when(dishRepository.existsByName("Spaghetti Carbonara")).thenReturn(true);

        boolean result = dishService.existsByName("Spaghetti Carbonara");

        assertTrue(result);
    }
}
