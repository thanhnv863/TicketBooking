package com.example.be.entity;

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

import java.util.Date;

@Entity
@Table(name = "ticket")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ticket_price", referencedColumnName = "id")
    private TicketPrice ticketPrice;

    @ManyToOne
    @JoinColumn(name = "id_chair", referencedColumnName = "id")
    private Chair chair;

    @ManyToOne
    @JoinColumn(name = "id_type_ticket", referencedColumnName = "id")
    private TypeTicket typeTicket;

    @ManyToOne
    @JoinColumn(name = "id_show_time", referencedColumnName = "id")
    private ShowTime showTime;

    @NotNull
    @Column(name = "status")
    private Integer status;

    @Column(name = "code")
    private String code;

    @NotNull
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @NotNull
    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "updated_time")
    private Date updatedTime;

}
