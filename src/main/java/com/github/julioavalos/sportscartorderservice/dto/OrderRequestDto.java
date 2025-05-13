package com.github.julioavalos.sportscartorderservice.dto;

import lombok.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDto {

    private Long userId;

    @NotEmpty(message = "Shipping address is required")
    private String shippingAddress;

    @NotEmpty(message = "Order must contain at least one item")
    private List<OrderItemDto> items;

}