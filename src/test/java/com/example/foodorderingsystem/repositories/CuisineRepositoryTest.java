package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Cuisine;
import com.example.foodorderingsystem.services.implementations.CuisineServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CuisineRepositoryTest {

    @Mock
    private CuisineRepository cuisineRepository;

    @InjectMocks
    private CuisineServiceImpl cuisineService;

    @Test
    public void testFindByName() {
        Cuisine cuisine = new Cuisine("Italian");

        when(cuisineRepository.findByName("Italian")).thenReturn(cuisine);

        Cuisine result = cuisineService.findByName("Italian");

        assertNotNull(result);
        assertEquals("Italian", result.getName());
    }

    @Test
    public void testExistsByName() {
        when(cuisineRepository.existsByName("Italian")).thenReturn(true);

        boolean result = cuisineService.existsByName("Italian");

        assertTrue(result);
    }
}
