package com.example.be.customer.message.request;

import com.example.be.entity.Employee;
import com.example.be.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderTimeLineRequest {
    private String type;
    private String note;
    private Date createdTime;
    private Order order;
    private Employee employee;
}
