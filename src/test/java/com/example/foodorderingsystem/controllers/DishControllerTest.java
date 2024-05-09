package com.example.foodorderingsystem.controllers;

import com.example.foodorderingsystem.entities.Dish;
import com.example.foodorderingsystem.services.interfaces.DishService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class DishControllerTest {

    @Mock
    private DishService dishService;

    @InjectMocks
    private DishController dishController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(dishController).build();
    }

    @Test
    public void testSave() throws Exception {
        Dish dish = new Dish("Pasta Carbonara", 12.99, "Creamy pasta with bacon and cheese");
        when(dishService.save(any(Dish.class))).thenReturn(dish);

        mockMvc.perform(post("/dish")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Pasta Carbonara\",\"price\":12.99,\"details\":\"Creamy pasta with bacon and cheese\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Pasta Carbonara")));

        verify(dishService, times(1)).save(any(Dish.class));
    }

    @Test
    public void testFindAll() throws Exception {
        Dish dish1 = new Dish("Pasta Carbonara", 12.99, "Creamy pasta with bacon and cheese");
        Dish dish2 = new Dish("Margherita Pizza", 10.99, "Classic Italian pizza with tomato and mozzarella");
        List<Dish> dishes = Arrays.asList(dish1, dish2);
        when(dishService.findAll()).thenReturn(dishes);

        mockMvc.perform(get("/dish"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Pasta Carbonara")))
                .andExpect(jsonPath("$[1].name", is("Margherita Pizza")));

        verify(dishService, times(1)).findAll();
    }

    @Test
    public void testFindByName() throws Exception {
        Dish dish = new Dish("Pasta Carbonara", 12.99, "Creamy pasta with bacon and cheese");
        when(dishService.findByName("Pasta Carbonara")).thenReturn(dish);

        mockMvc.perform(get("/dish/Pasta Carbonara"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Pasta Carbonara")));

        verify(dishService, times(1)).findByName("Pasta Carbonara");
    }

    @Test
    public void testUpdate() throws Exception {
        Dish dish = new Dish("Pasta Carbonara", 12.99, "Creamy pasta with bacon and cheese");
        when(dishService.update(any(Dish.class))).thenReturn(dish);

        mockMvc.perform(put("/dish")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Pasta Carbonara\",\"price\":12.99,\"details\":\"Creamy pasta with bacon and cheese\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Pasta Carbonara")));

        verify(dishService, times(1)).update(any(Dish.class));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/dish")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Pasta Carbonara\",\"price\":12.99,\"details\":\"Creamy pasta with bacon and cheese\"}"))
                .andExpect(status().isOk());

        verify(dishService, times(1)).delete(any(Dish.class));
    }
}
