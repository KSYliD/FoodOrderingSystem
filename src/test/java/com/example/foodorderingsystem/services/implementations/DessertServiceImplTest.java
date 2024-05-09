package com.example.foodorderingsystem.services.implementations;

import com.example.foodorderingsystem.entities.Dessert;
import com.example.foodorderingsystem.repositories.DessertRepository;
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

public class DessertServiceImplTest {

    @Mock
    private DessertRepository dessertRepository;

    @InjectMocks
    private DessertServiceImpl dessertService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Dessert dessert = new Dessert("Chocolate Cake", 6.99, "Decadent chocolate cake", null);
        when(dessertRepository.save(any(Dessert.class))).thenReturn(dessert);

        Dessert savedDessert = dessertService.save(dessert);

        assertNotNull(savedDessert);
        assertEquals("Chocolate Cake", savedDessert.getName());
        verify(dessertRepository, times(1)).save(any(Dessert.class));
    }

    @Test
    public void testFindAll() {
        Dessert dessert1 = new Dessert("Chocolate Cake", 6.99, "Decadent chocolate cake", null);
        Dessert dessert2 = new Dessert("Cheesecake", 5.99, "Creamy cheesecake", null);
        List<Dessert> desserts = Arrays.asList(dessert1, dessert2);
        when(dessertRepository.findAll()).thenReturn(desserts);

        List<Dessert> foundDesserts = dessertService.findAll();

        assertNotNull(foundDesserts);
        assertEquals(2, foundDesserts.size());
        assertEquals("Chocolate Cake", foundDesserts.get(0).getName());
        assertEquals("Cheesecake", foundDesserts.get(1).getName());
        verify(dessertRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Dessert dessert = new Dessert("Chocolate Cake", 6.99, "Decadent chocolate cake", null);
        when(dessertRepository.findById(1L)).thenReturn(dessert);

        Dessert foundDessert = dessertService.findById(1L);

        assertNotNull(foundDessert);
        assertEquals("Chocolate Cake", foundDessert.getName());
        verify(dessertRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindByName() {
        Dessert dessert = new Dessert("Chocolate Cake", 6.99, "Decadent chocolate cake", null);
        when(dessertRepository.findByName("Chocolate Cake")).thenReturn(dessert);

        Dessert foundDessert = dessertService.findByName("Chocolate Cake");

        assertNotNull(foundDessert);
        assertEquals("Chocolate Cake", foundDessert.getName());
        verify(dessertRepository, times(1)).findByName("Chocolate Cake");
    }

    @Test
    public void testUpdate() {
        Dessert dessert = new Dessert("Chocolate Cake", 6.99, "Decadent chocolate cake", null);
        Dessert updatedDessert = new Dessert("Cheesecake", 5.99, "Creamy cheesecake", null);
        updatedDessert.setId(1L);

        when(dessertRepository.findById(1L)).thenReturn(dessert);
        when(dessertRepository.save(any(Dessert.class))).thenReturn(updatedDessert);

        Dessert result = dessertService.update(updatedDessert);

        assertNotNull(result);
        assertEquals("Cheesecake", result.getName());
        verify(dessertRepository, times(1)).findById(1L);
        verify(dessertRepository, times(1)).save(any(Dessert.class));
    }

    @Test
    public void testDelete() {
        Dessert dessert = new Dessert("Chocolate Cake", 6.99, "Decadent chocolate cake", null);
        dessert.setId(1L);

        dessertService.delete(dessert);

        verify(dessertRepository, times(1)).delete(dessert);
    }

    @Test
    public void testExistsByName() {
        when(dessertRepository.existsByName("Chocolate Cake")).thenReturn(true);

        boolean result = dessertService.existsByName("Chocolate Cake");

        assertTrue(result);
        verify(dessertRepository, times(1)).existsByName("Chocolate Cake");
    }
}
