package com.example.be.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "order")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    private Employee employee;

    @Column(name = "code")
    private String code;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "time_order")
    private Time timeOrder;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "total_after_reduction")
    private BigDecimal totalAfter_reduction;

    @NotNull
    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @NotNull
    @Column(name = "created_time")
    private Time createdTime;

    @Column(name = "updated_time")
    private Time updatedTime;

}
