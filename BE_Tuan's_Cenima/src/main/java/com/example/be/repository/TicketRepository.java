package com.example.be.repository;

import com.example.be.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.be.employee.message.response.TicketResponse;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT NEW com.example.be.employee.message.response.TicketResponse" +
            "(ot.price, ot.ticket.code, ot.order.customer.code," +
            "ot.order.employee.code, ot.order.code," +
            "ot.ticket.chair.name, ot.ticket.chair.chairType.name, ot.ticket.status, ot.ticket.createdTime)" +
            "   FROM OrderTicket ot WHERE ot.ticket.id = :idTicket")
    TicketResponse getTicket(@Param("idTicket") Long idTicket);

    Ticket getTicketByCode(String code);
}
