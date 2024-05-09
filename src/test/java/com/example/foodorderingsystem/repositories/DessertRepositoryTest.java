package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Dessert;
import com.example.foodorderingsystem.services.implementations.DessertServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DessertRepositoryTest {

    @Mock
    private DessertRepository dessertRepository;

    @InjectMocks
    private DessertServiceImpl dessertService;

    @Test
    public void testFindByName() {
        Dessert dessert = new Dessert("Cheesecake", 7.99, "Creamy dessert with a graham cracker crust", null);

        when(dessertRepository.findByName("Cheesecake")).thenReturn(dessert);

        Dessert result = dessertService.findByName("Cheesecake");

        assertNotNull(result);
        assertEquals("Cheesecake", result.getName());
    }

    @Test
    public void testExistsByName() {
        when(dessertRepository.existsByName("Cheesecake")).thenReturn(true);

        boolean result = dessertService.existsByName("Cheesecake");

        assertTrue(result);
    }
}
