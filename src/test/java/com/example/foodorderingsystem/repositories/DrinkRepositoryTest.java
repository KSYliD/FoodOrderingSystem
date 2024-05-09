package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Drink;
import com.example.foodorderingsystem.services.implementations.DrinkServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DrinkRepositoryTest {

    @Mock
    private DrinkRepository drinkRepository;

    @InjectMocks
    private DrinkServiceImpl drinkService;

    @Test
    public void testFindByName() {
        Drink drink = new Drink("Cola", 2.99, "Classic carbonated beverage");

        when(drinkRepository.findByName("Cola")).thenReturn(drink);

        Drink result = drinkService.findByName("Cola");

        assertNotNull(result);
        assertEquals("Cola", result.getName());
    }

    @Test
    public void testExistsByName() {
        when(drinkRepository.existsByName("Cola")).thenReturn(true);

        boolean result = drinkService.existsByName("Cola");

        assertTrue(result);
    }
}
