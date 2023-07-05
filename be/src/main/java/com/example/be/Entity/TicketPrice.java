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

import java.sql.Time;

@Entity
@Table(name = "ticket_price")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketPrice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_type_ticket", referencedColumnName = "id")
    private TypeTicket customer;

    @ManyToOne
    @JoinColumn(name = "id_type_chair", referencedColumnName = "id")
    private ChairType chairType;

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
