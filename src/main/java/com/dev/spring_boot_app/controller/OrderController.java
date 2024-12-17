package com.dev.spring_boot_app.controller;

import com.dev.spring_boot_app.model.Order;
import com.dev.spring_boot_app.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/hello")
    public String getHello() {
        return "Hello from Spring-Boot-App - v1";
    }

    @GetMapping(path="/orders")
    public ResponseEntity<Order> getOrder(@Validated @RequestParam String orderId) {
        System.out.println("Get request for orderId: " + orderId);
        Order order = orderService.fetchOrder(orderId);
        System.out.println("Get response body: " + order);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PostMapping(path="/orders")
    public ResponseEntity<Order> saveOrder(@Validated @RequestBody Order order) {
        System.out.println("Post request for order: " + order);
        orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
