package com.github.julioavalos.sportscartorderservice.repository;

import com.github.julioavalos.sportscartorderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);

    @Query("SELECT new map(o.id as id, o.userId as userId, " +
            "o.shippingAddress as shippingAddress, o.status as status, " +
            "o.createdAt as createdAt, " +
            "SUM(oi.unitPrice * oi.quantity) as total) " +
            "FROM Order o " +
            "JOIN o.orderItems oi " +
            "WHERE o.userId = :userId " +
            "GROUP BY o.id, o.userId, o.shippingAddress, o.status, o.createdAt")
    List<Map<String, Object>> getOrderSummary(@Param("userId") Long userId);
}
