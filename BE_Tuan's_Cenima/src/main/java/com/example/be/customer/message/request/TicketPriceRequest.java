package com.example.be.customer.message.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketPriceRequest {
    private Long idTicketType;
    private Long idChairType;
    private BigDecimal price;
}
