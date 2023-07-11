package com.example.be.customer.message.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketRequest {
    private Long idChair;
    private Long idTypeTickket;
    private Long idShowTime;
    private String code;
    private Integer status;
}
