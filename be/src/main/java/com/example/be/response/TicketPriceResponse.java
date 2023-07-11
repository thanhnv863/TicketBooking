package com.example.be.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TicketPriceResponse {
    private String nameTypeTicket;
    private String nameTypeChair;
    private BigDecimal price;
}
