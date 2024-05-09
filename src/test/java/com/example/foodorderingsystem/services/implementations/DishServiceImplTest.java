package com.example.foodorderingsystem.services.implementations;

import com.example.foodorderingsystem.entities.Dish;
import com.example.foodorderingsystem.repositories.DishRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DishServiceImplTest {

    @Mock
    private DishRepository dishRepository;

    @InjectMocks
    private DishServiceImpl dishService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Dish dish = new Dish("Pasta", 12.99, "Spaghetti with marinara sauce", null);
        when(dishRepository.save(any(Dish.class))).thenReturn(dish);

        Dish savedDish = dishService.save(dish);

        assertNotNull(savedDish);
        assertEquals("Pasta", savedDish.getName());
        verify(dishRepository, times(1)).save(any(Dish.class));
    }

    @Test
    public void testFindAll() {
        Dish dish1 = new Dish("Pasta", 12.99, "Spaghetti with marinara sauce", null);
        Dish dish2 = new Dish("Pizza", 15.99, "Margherita pizza", null);
        List<Dish> dishes = Arrays.asList(dish1, dish2);
        when(dishRepository.findAll()).thenReturn(dishes);

        List<Dish> foundDishes = dishService.findAll();

        assertNotNull(foundDishes);
        assertEquals(2, foundDishes.size());
        assertEquals("Pasta", foundDishes.get(0).getName());
        assertEquals("Pizza", foundDishes.get(1).getName());
        verify(dishRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Dish dish = new Dish("Pasta", 12.99, "Spaghetti with marinara sauce", null);
        when(dishRepository.findById(1L)).thenReturn(dish);

        Dish foundDish = dishService.findById(1L);

        assertNotNull(foundDish);
        assertEquals("Pasta", foundDish.getName());
        verify(dishRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindByName() {
        Dish dish = new Dish("Pasta", 12.99, "Spaghetti with marinara sauce", null);
        when(dishRepository.findByName("Pasta")).thenReturn(dish);

        Dish foundDish = dishService.findByName("Pasta");

        assertNotNull(foundDish);
        assertEquals("Pasta", foundDish.getName());
        verify(dishRepository, times(1)).findByName("Pasta");
    }

    @Test
    public void testUpdate() {
        Dish dish = new Dish("Pasta", 12.99, "Spaghetti with marinara sauce", null);
        Dish updatedDish = new Dish("Pizza", 15.99, "Margherita pizza", null);
        updatedDish.setId(1L);

        when(dishRepository.findById(1L)).thenReturn(dish);
        when(dishRepository.save(any(Dish.class))).thenReturn(updatedDish);

        Dish result = dishService.update(updatedDish);

        assertNotNull(result);
        assertEquals("Pizza", result.getName());
        verify(dishRepository, times(1)).findById(1L);
        verify(dishRepository, times(1)).save(any(Dish.class));
    }

    @Test
    public void testDelete() {
        Dish dish = new Dish("Pasta", 12.99, "Spaghetti with marinara sauce", null);
        dish.setId(1L);

        dishService.delete(dish);

        verify(dishRepository, times(1)).delete(dish);
    }

    @Test
    public void testExistsByName() {
        when(dishRepository.existsByName("Pasta")).thenReturn(true);

        boolean result = dishService.existsByName("Pasta");

        assertTrue(result);
        verify(dishRepository, times(1)).existsByName("Pasta");
    }
}
