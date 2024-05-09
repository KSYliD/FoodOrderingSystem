package com.example.foodorderingsystem.controllers;

import com.example.foodorderingsystem.entities.Order;
import com.example.foodorderingsystem.services.interfaces.OrderService;
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

public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void testOrderFood() throws Exception {
        Order order = new Order(1, null, null, null, "Table 1");
        when(orderService.save(any(Order.class))).thenReturn(order);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"tableNum\":1,\"details\":\"Table 1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.tableNum", is(1)))
                .andExpect(jsonPath("$.details", is("Table 1")));

        verify(orderService, times(1)).save(any(Order.class));
    }

    @Test
    public void testFindAll() throws Exception {
        Order order1 = new Order(1, null, null, null, "Table 1");
        Order order2 = new Order(2, null, null, null, "Table 2");
        List<Order> orders = Arrays.asList(order1, order2);
        when(orderService.findAll()).thenReturn(orders);

        mockMvc.perform(get("/order"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].tableNum", is(1)))
                .andExpect(jsonPath("$[1].tableNum", is(2)));

        verify(orderService, times(1)).findAll();
    }

    @Test
    public void testFindById() throws Exception {
        Order order = new Order(1, null, null, null, "Table 1");
        when(orderService.findById(1L)).thenReturn(order);

        mockMvc.perform(get("/order/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.tableNum", is(1)))
                .andExpect(jsonPath("$.details", is("Table 1")));

        verify(orderService, times(1)).findById(1L);
    }

    @Test
    public void testUpdate() throws Exception {
        Order order = new Order(1, null, null, null, "Table 1");
        when(orderService.update(any(Order.class))).thenReturn(order);

        mockMvc.perform(put("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"tableNum\":1,\"details\":\"Table 1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.tableNum", is(1)))
                .andExpect(jsonPath("$.details", is("Table 1")));

        verify(orderService, times(1)).update(any(Order.class));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"tableNum\":1,\"details\":\"Table 1\"}"))
                .andExpect(status().isOk());

        verify(orderService, times(1)).delete(any(Order.class));
    }
}
