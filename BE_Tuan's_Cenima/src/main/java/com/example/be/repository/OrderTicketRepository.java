package com.example.be.repository;

import com.example.be.entity.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTicketRepository extends JpaRepository<OrderTicket, Long> {
    @Query(value = "SELECT * FROM ticket_booking.order_ticket where order_ticket.id_order = ?1",nativeQuery = true)
    List<OrderTicket> listOrderTicketByIdOrder(Long id);
}
