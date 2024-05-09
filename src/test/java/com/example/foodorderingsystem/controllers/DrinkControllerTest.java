package com.example.foodorderingsystem.controllers;

import com.example.foodorderingsystem.entities.Drink;
import com.example.foodorderingsystem.services.interfaces.DrinkService;
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

public class DrinkControllerTest {

    @Mock
    private DrinkService drinkService;

    @InjectMocks
    private DrinkController drinkController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(drinkController).build();
    }

    @Test
    public void testSave() throws Exception {
        Drink drink = new Drink("Cola", 1.99, "Classic carbonated beverage");
        when(drinkService.save(any(Drink.class))).thenReturn(drink);

        mockMvc.perform(post("/drink")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Cola\",\"price\":1.99,\"details\":\"Classic carbonated beverage\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Cola")));

        verify(drinkService, times(1)).save(any(Drink.class));
    }

    @Test
    public void testFindAll() throws Exception {
        Drink drink1 = new Drink("Cola", 1.99, "Classic carbonated beverage");
        Drink drink2 = new Drink("Orange Juice", 2.49, "Freshly squeezed orange juice");
        List<Drink> drinks = Arrays.asList(drink1, drink2);
        when(drinkService.findAll()).thenReturn(drinks);

        mockMvc.perform(get("/drink"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Cola")))
                .andExpect(jsonPath("$[1].name", is("Orange Juice")));

        verify(drinkService, times(1)).findAll();
    }

    @Test
    public void testFindByName() throws Exception {
        Drink drink = new Drink("Cola", 1.99, "Classic carbonated beverage");
        when(drinkService.findByName("Cola")).thenReturn(drink);

        mockMvc.perform(get("/drink/Cola"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Cola")));

        verify(drinkService, times(1)).findByName("Cola");
    }

    @Test
    public void testUpdate() throws Exception {
        Drink drink = new Drink("Cola", 1.99, "Classic carbonated beverage");
        when(drinkService.update(any(Drink.class))).thenReturn(drink);

        mockMvc.perform(put("/drink")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Cola\",\"price\":1.99,\"details\":\"Classic carbonated beverage\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Cola")));

        verify(drinkService, times(1)).update(any(Drink.class));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/drink")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Cola\",\"price\":1.99,\"details\":\"Classic carbonated beverage\"}"))
                .andExpect(status().isOk());

        verify(drinkService, times(1)).delete(any(Drink.class));
    }
}
