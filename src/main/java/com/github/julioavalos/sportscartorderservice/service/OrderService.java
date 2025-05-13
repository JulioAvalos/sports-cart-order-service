package com.github.julioavalos.sportscartorderservice.service;

import com.github.julioavalos.sportscartorderservice.dto.OrderRequestDto;
import com.github.julioavalos.sportscartorderservice.model.Order;
import com.github.julioavalos.sportscartorderservice.model.OrderItem;
import com.github.julioavalos.sportscartorderservice.repository.OrderRepository;
import com.github.julioavalos.sportscartorderservice.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final OrderItemRepository itemRepo;

    @Transactional
    public Order createOrder(OrderRequestDto request) {
        final Order order = orderRepo.save(Order.builder()
                .userId(request.getUserId())
                .shippingAddress(request.getShippingAddress())
                .status("CONFIRMED")
                .createdAt(LocalDateTime.now())
                .build());

        List<OrderItem> items = request.getItems().stream()
                .map(dto -> OrderItem.builder()
                        .order(order)
                        .productId(dto.getProductId())
                        .quantity(dto.getQuantity())
                        .unitPrice(dto.getUnitPrice())
                        .build())
                .collect(Collectors.toList());
        itemRepo.saveAll(items);
        return order;
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepo.findByUserId(userId);
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepo.findById(orderId);
    }
}