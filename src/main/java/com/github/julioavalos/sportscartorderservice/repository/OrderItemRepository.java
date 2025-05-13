package com.github.julioavalos.sportscartorderservice.repository;

import com.github.julioavalos.sportscartorderservice.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);
}