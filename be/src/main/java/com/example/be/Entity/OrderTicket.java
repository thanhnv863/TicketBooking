package com.example.be.Entity;

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
@Table(name = "order_ticket")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_ticket", referencedColumnName = "id")
    private Ticket ticket;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private Integer status;

}
