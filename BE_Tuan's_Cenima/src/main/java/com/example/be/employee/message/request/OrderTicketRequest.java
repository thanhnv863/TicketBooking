package com.example.be.employee.message.request;

import com.example.be.entity.Order;
import com.example.be.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderTicketRequest {
    private Order order;

    private Ticket ticket;

    private BigDecimal price;

    private String note;

    private Integer status;
}
