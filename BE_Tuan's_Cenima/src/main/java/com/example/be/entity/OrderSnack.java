package com.example.be.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "order_snack")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSnack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_snack", referencedColumnName = "id")
    private Snacks snacks;

    @ManyToOne
    @JoinColumn(name = "id_combo", referencedColumnName = "id")
    private Combo combo;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quanitty;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private Integer status;

}
