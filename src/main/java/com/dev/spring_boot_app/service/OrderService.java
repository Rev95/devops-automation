package com.dev.spring_boot_app.service;

import com.dev.spring_boot_app.model.Order;
import com.dev.spring_boot_app.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public Order fetchOrder(String orderId) {
//        Order order = orderRepository.findById(orderId).orElse(null);
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isEmpty()) {
            System.out.println("No such order found with orderId: " + orderId);
            return null;
        }
        System.out.println("Order found: " + order.get());
        return order.get();
    }
}
