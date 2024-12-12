package com.dev.spring_boot_app.service;

import com.dev.spring_boot_app.model.Order;
import com.dev.spring_boot_app.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTests {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void fetchOrder_ExistingOrder_ReturnsOrder() {
        // Arrange
        String orderId = "123";
        Order mockOrder = new Order(orderId, "2023-12-11", "500");
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(mockOrder));

        // Act
        Order result = orderService.fetchOrder(orderId);

        // Assert
        assertNotNull(result);
        assertEquals(orderId, result.getOrderId());
        assertEquals("2023-12-11", result.getOrderDate());
        assertEquals("500", result.getTotalAmount());
        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    void fetchOrder_NonExistingOrder_ReturnsNull() {
        // Arrange
        String orderId = "999";
        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        // Act
        Order result = orderService.fetchOrder(orderId);

        // Assert
        assertNull(result);
        verify(orderRepository, times(1)).findById(orderId);
    }
}
