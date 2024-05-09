package com.example.foodorderingsystem.controllers;

import com.example.foodorderingsystem.entities.Cuisine;
import com.example.foodorderingsystem.services.interfaces.CuisineService;
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

public class CuisineControllerTest {

    @Mock
    private CuisineService cuisineService;

    @InjectMocks
    private CuisineController cuisineController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cuisineController).build();
    }

    @Test
    public void testSave() throws Exception {
        Cuisine cuisine = new Cuisine("Italian");
        when(cuisineService.save(any(Cuisine.class))).thenReturn(cuisine);

        mockMvc.perform(post("/cuisine")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Italian\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Italian")));

        verify(cuisineService, times(1)).save(any(Cuisine.class));
    }

    @Test
    public void testFindAll() throws Exception {
        Cuisine cuisine1 = new Cuisine("Italian");
        Cuisine cuisine2 = new Cuisine("Mexican");
        List<Cuisine> cuisines = Arrays.asList(cuisine1, cuisine2);
        when(cuisineService.findAll()).thenReturn(cuisines);

        mockMvc.perform(get("/cuisine"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Italian")))
                .andExpect(jsonPath("$[1].name", is("Mexican")));

        verify(cuisineService, times(1)).findAll();
    }

    @Test
    public void testFindByName() throws Exception {
        Cuisine cuisine = new Cuisine("Italian");
        when(cuisineService.findByName("Italian")).thenReturn(cuisine);

        mockMvc.perform(get("/cuisine/Italian"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Italian")));

        verify(cuisineService, times(1)).findByName("Italian");
    }

    @Test
    public void testUpdate() throws Exception {
        Cuisine cuisine = new Cuisine("Italian");
        when(cuisineService.update(any(Cuisine.class))).thenReturn(cuisine);

        mockMvc.perform(put("/cuisine")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Italian\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Italian")));

        verify(cuisineService, times(1)).update(any(Cuisine.class));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/cuisine")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Italian\"}"))
                .andExpect(status().isOk());

        verify(cuisineService, times(1)).delete(any(Cuisine.class));
    }
}
