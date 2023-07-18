package com.example.be.employee.message.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TicketResponse {
    private Long id;
    private BigDecimal price;
    private String code;
    private String customerCode;
    private String employeeCode;
    private String ordersCode;
    private String chairName;
    private String chairTypeName;
    private Integer status;
    private Date createdTime;
    private String room;
    private Date time;
    private String movie;

    public TicketResponse(BigDecimal price, String code, String customerCode, String employeeCode,
                          String ordersCode, String chairName, String chairTypeName,
                          Integer status, Date createdTime, Long id, String room, Date time, String movie) {
        this.price = price;
        this.code = code;
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.ordersCode = ordersCode;
        this.chairName = chairName;
        this.chairTypeName = chairTypeName;
        this.status = status;
        this.createdTime = createdTime;
        this.id = id;
        this.room = room;
        this.time = time;
        this.movie = movie;
    }
}
