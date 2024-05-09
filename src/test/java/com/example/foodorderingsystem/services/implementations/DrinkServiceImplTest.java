package com.example.foodorderingsystem.services.implementations;

import com.example.foodorderingsystem.entities.Drink;
import com.example.foodorderingsystem.repositories.DrinkRepository;
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

public class DrinkServiceImplTest {

    @Mock
    private DrinkRepository drinkRepository;

    @InjectMocks
    private DrinkServiceImpl drinkService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Drink drink = new Drink("Coke", 2.5, "Refreshing cola drink");
        when(drinkRepository.save(any(Drink.class))).thenReturn(drink);

        Drink savedDrink = drinkService.save(drink);

        assertNotNull(savedDrink);
        assertEquals("Coke", savedDrink.getName());
        verify(drinkRepository, times(1)).save(any(Drink.class));
    }

    @Test
    public void testFindAll() {
        Drink drink1 = new Drink("Coke", 2.5, "Refreshing cola drink");
        Drink drink2 = new Drink("Orange Juice", 3.0, "Freshly squeezed orange juice");
        List<Drink> drinks = Arrays.asList(drink1, drink2);
        when(drinkRepository.findAll()).thenReturn(drinks);

        List<Drink> foundDrinks = drinkService.findAll();

        assertNotNull(foundDrinks);
        assertEquals(2, foundDrinks.size());
        assertEquals("Coke", foundDrinks.get(0).getName());
        assertEquals("Orange Juice", foundDrinks.get(1).getName());
        verify(drinkRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Drink drink = new Drink("Coke", 2.5, "Refreshing cola drink");
        when(drinkRepository.findById(1L)).thenReturn(drink);

        Drink foundDrink = drinkService.findById(1L);

        assertNotNull(foundDrink);
        assertEquals("Coke", foundDrink.getName());
        verify(drinkRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindByName() {
        Drink drink = new Drink("Coke", 2.5, "Refreshing cola drink");
        when(drinkRepository.findByName("Coke")).thenReturn(drink);

        Drink foundDrink = drinkService.findByName("Coke");

        assertNotNull(foundDrink);
        assertEquals("Coke", foundDrink.getName());
        verify(drinkRepository, times(1)).findByName("Coke");
    }

    @Test
    public void testUpdate() {
        Drink drink = new Drink("Coke", 2.5, "Refreshing cola drink");
        Drink updatedDrink = new Drink("Pepsi", 2.75, "Refreshing cola drink");
        updatedDrink.setId(1L);

        when(drinkRepository.findById(1L)).thenReturn(drink);
        when(drinkRepository.save(any(Drink.class))).thenReturn(updatedDrink);

        Drink result = drinkService.update(updatedDrink);

        assertNotNull(result);
        assertEquals("Pepsi", result.getName());
        verify(drinkRepository, times(1)).findById(1L);
        verify(drinkRepository, times(1)).save(any(Drink.class));
    }

    @Test
    public void testDelete() {
        Drink drink = new Drink("Coke", 2.5, "Refreshing cola drink");
        drink.setId(1L);

        drinkService.delete(drink);

        verify(drinkRepository, times(1)).delete(drink);
    }

    @Test
    public void testExistsByName() {
        when(drinkRepository.existsByName("Coke")).thenReturn(true);

        boolean result = drinkService.existsByName("Coke");

        assertTrue(result);
        verify(drinkRepository, times(1)).existsByName("Coke");
    }
}
