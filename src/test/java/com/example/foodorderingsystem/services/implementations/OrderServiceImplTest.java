package com.example.foodorderingsystem.services.implementations;

import com.example.foodorderingsystem.entities.Order;
import com.example.foodorderingsystem.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Order order = new Order(1, null, null, null, "Some details");
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order savedOrder = orderService.save(order);

        assertNotNull(savedOrder);
        assertEquals(1, savedOrder.getTableNum());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    public void testFindAll() {
        Order order1 = new Order(1, null, null, null, "Some details");
        Order order2 = new Order(2, null, null, null, "Some other details");
        List<Order> orders = Arrays.asList(order1, order2);
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> foundOrders = orderService.findAll();

        assertNotNull(foundOrders);
        assertEquals(2, foundOrders.size());
        assertEquals(1, foundOrders.get(0).getTableNum());
        assertEquals(2, foundOrders.get(1).getTableNum());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Order order = new Order(1, null, null, null, "Some details");
        when(orderRepository.findById(1L)).thenReturn(order);

        Order foundOrder = orderService.findById(1L);

        assertNotNull(foundOrder);
        assertEquals(1, foundOrder.getTableNum());
        verify(orderRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdate() {
        Order order = new Order(1, null, null, null, "Some details");
        Order updatedOrder = new Order(1, null, null, null, "Updated details");
        updatedOrder.setId(1L);

        when(orderRepository.findById(1L)).thenReturn(order);
        when(orderRepository.save(any(Order.class))).thenReturn(updatedOrder);

        Order result = orderService.update(updatedOrder);

        assertNotNull(result);
        assertEquals("Updated details", result.getDetails());
        verify(orderRepository, times(1)).findById(1L);
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    public void testDelete() {
        Order order = new Order(1, null, null, null, "Some details");
        order.setId(1L);

        orderService.delete(order);

        verify(orderRepository, times(1)).delete(order);
    }
}
