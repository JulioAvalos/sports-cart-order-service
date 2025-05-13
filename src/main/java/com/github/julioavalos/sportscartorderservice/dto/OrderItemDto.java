package com.github.julioavalos.sportscartorderservice.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDto {
    private Long productId;
    private int quantity;
    private BigDecimal unitPrice;
}
