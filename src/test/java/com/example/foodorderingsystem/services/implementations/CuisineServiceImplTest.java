package com.example.foodorderingsystem.services.implementations;

import com.example.foodorderingsystem.entities.Cuisine;
import com.example.foodorderingsystem.repositories.CuisineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CuisineServiceImplTest {

    @Mock
    private CuisineRepository cuisineRepository;

    @InjectMocks
    private CuisineServiceImpl cuisineService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Cuisine cuisine = new Cuisine("Italian");
        when(cuisineRepository.save(any(Cuisine.class))).thenReturn(cuisine);

        Cuisine savedCuisine = cuisineService.save(cuisine);

        assertNotNull(savedCuisine);
        assertEquals("Italian", savedCuisine.getName());
        verify(cuisineRepository, times(1)).save(any(Cuisine.class));
    }

    @Test
    public void testFindAll() {
        Cuisine cuisine1 = new Cuisine("Italian");
        Cuisine cuisine2 = new Cuisine("Mexican");
        List<Cuisine> cuisines = Arrays.asList(cuisine1, cuisine2);
        when(cuisineRepository.findAll()).thenReturn(cuisines);

        List<Cuisine> foundCuisines = cuisineService.findAll();

        assertNotNull(foundCuisines);
        assertEquals(2, foundCuisines.size());
        assertEquals("Italian", foundCuisines.get(0).getName());
        assertEquals("Mexican", foundCuisines.get(1).getName());
        verify(cuisineRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Cuisine cuisine = new Cuisine("Italian");
        when(cuisineRepository.findById(1L)).thenReturn(cuisine);

        Cuisine foundCuisine = cuisineService.findById(1L);

        assertNotNull(foundCuisine);
        assertEquals("Italian", foundCuisine.getName());
        verify(cuisineRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindByName() {
        Cuisine cuisine = new Cuisine("Italian");
        when(cuisineRepository.findByName("Italian")).thenReturn(cuisine);

        Cuisine foundCuisine = cuisineService.findByName("Italian");

        assertNotNull(foundCuisine);
        assertEquals("Italian", foundCuisine.getName());
        verify(cuisineRepository, times(1)).findByName("Italian");
    }

    @Test
    public void testUpdate() {
        Cuisine cuisine = new Cuisine("Italian");
        Cuisine updatedCuisine = new Cuisine("Mexican");
        updatedCuisine.setId(1L);

        when(cuisineRepository.findById(1L)).thenReturn(cuisine);
        when(cuisineRepository.save(any(Cuisine.class))).thenReturn(updatedCuisine);

        Cuisine result = cuisineService.update(updatedCuisine);

        assertNotNull(result);
        assertEquals("Mexican", result.getName());
        verify(cuisineRepository, times(1)).findById(1L);
        verify(cuisineRepository, times(1)).save(any(Cuisine.class));
    }

    @Test
    public void testDelete() {
        Cuisine cuisine = new Cuisine("Italian");
        cuisine.setId(1L);

        cuisineService.delete(cuisine);

        verify(cuisineRepository, times(1)).delete(cuisine);
    }

    @Test
    public void testExistsByName() {
        when(cuisineRepository.existsByName("Italian")).thenReturn(true);

        boolean result = cuisineService.existsByName("Italian");

        assertTrue(result);
        verify(cuisineRepository, times(1)).existsByName("Italian");
    }
}
