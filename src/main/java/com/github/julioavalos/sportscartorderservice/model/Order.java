package com.github.julioavalos.sportscartorderservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")  // Changed from "order" to "orders"
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String shippingAddress;
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
}