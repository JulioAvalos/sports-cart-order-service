package com.github.julioavalos.sportscartorderservice.controller;

import com.github.julioavalos.sportscartorderservice.dto.OrderRequestDto;
import com.github.julioavalos.sportscartorderservice.model.Order;
import com.github.julioavalos.sportscartorderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Validated
public class OrderController {

    private final OrderService service;

    @PostMapping("/confirm")
    public ResponseEntity<Order> confirmOrder(@Valid @RequestBody OrderRequestDto request) {
        Order order = service.createOrder(request);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Order>> orderHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getOrdersByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return service.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
