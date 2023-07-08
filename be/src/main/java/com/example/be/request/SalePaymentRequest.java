package com.example.be.request;

import com.example.be.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SalePaymentRequest {
    private Order order;
    private BigDecimal amount;
    private String description;
}
