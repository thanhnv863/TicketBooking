package com.example.be.customer.message.request;

import com.example.be.entity.Customer;
import com.example.be.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private String code;
    private BigDecimal totalAmount;
    private BigDecimal totalAfterReduction;
    private String createdBy;
    private Integer status;
    private Employee employee;
    private Customer customer;
    private String updatedBy;
    private String createdTime;
}
