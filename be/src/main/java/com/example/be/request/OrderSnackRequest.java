package com.example.be.request;

import com.example.be.entity.Order;
import com.example.be.entity.Snacks;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderSnackRequest {

    private Order order;

    private Snacks snacks;

    private Integer quanitty;

    private BigDecimal price;

    private String note;

    private Integer status;
}
