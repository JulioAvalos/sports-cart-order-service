package com.github.julioavalos.sportscartorderservice.repository;

import com.github.julioavalos.sportscartorderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
