package com.example.foodorderingsystem.controllers;

import com.example.foodorderingsystem.entities.Dessert;
import com.example.foodorderingsystem.services.interfaces.DessertService;
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

public class DessertControllerTest {

    @Mock
    private DessertService dessertService;

    @InjectMocks
    private DessertController dessertController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(dessertController).build();
    }

    @Test
    public void testSave() throws Exception {
        Dessert dessert = new Dessert("Cheesecake", 7.99, "Creamy dessert with a graham cracker crust");
        when(dessertService.save(any(Dessert.class))).thenReturn(dessert);

        mockMvc.perform(post("/dessert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Cheesecake\",\"price\":7.99,\"details\":\"Creamy dessert with a graham cracker crust\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Cheesecake")));

        verify(dessertService, times(1)).save(any(Dessert.class));
    }

    @Test
    public void testFindAll() throws Exception {
        Dessert dessert1 = new Dessert("Cheesecake", 7.99, "Creamy dessert with a graham cracker crust");
        Dessert dessert2 = new Dessert("Tiramisu", 8.99, "Classic Italian dessert");
        List<Dessert> desserts = Arrays.asList(dessert1, dessert2);
        when(dessertService.findAll()).thenReturn(desserts);

        mockMvc.perform(get("/dessert"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Cheesecake")))
                .andExpect(jsonPath("$[1].name", is("Tiramisu")));

        verify(dessertService, times(1)).findAll();
    }

    @Test
    public void testFindByName() throws Exception {
        Dessert dessert = new Dessert("Cheesecake", 7.99, "Creamy dessert with a graham cracker crust");
        when(dessertService.findByName("Cheesecake")).thenReturn(dessert);

        mockMvc.perform(get("/dessert/Cheesecake"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Cheesecake")));

        verify(dessertService, times(1)).findByName("Cheesecake");
    }

    @Test
    public void testUpdate() throws Exception {
        Dessert dessert = new Dessert("Cheesecake", 7.99, "Creamy dessert with a graham cracker crust");
        when(dessertService.update(any(Dessert.class))).thenReturn(dessert);

        mockMvc.perform(put("/dessert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Cheesecake\",\"price\":7.99,\"details\":\"Creamy dessert with a graham cracker crust\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Cheesecake")));

        verify(dessertService, times(1)).update(any(Dessert.class));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/dessert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Cheesecake\",\"price\":7.99,\"details\":\"Creamy dessert with a graham cracker crust\"}"))
                .andExpect(status().isOk());

        verify(dessertService, times(1)).delete(any(Dessert.class));
    }
}
