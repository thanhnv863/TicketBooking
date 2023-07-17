package com.example.be.repository;

import com.example.be.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            "ot.ticket.chair.name, ot.ticket.chair.chairType.name, ot.ticket.status," +
            " ot.ticket.createdTime, ot.ticket.id, ot.ticket.showTime.room.name, ot.ticket.showTime.time, " +
            "ot.ticket.showTime.movie.name)" +
            "   FROM OrderTicket ot WHERE ot.ticket.id = :idTicket")
    TicketResponse getTicket(@Param("idTicket") Long idTicket);

    Ticket getTicketByCode(String code);

    Page<Ticket> getTicketByStatus(Integer status, Pageable pageable);

    @Query("SELECT NEW com.example.be.employee.message.response.TicketResponse" +
            "(ot.price, ot.ticket.code, ot.order.customer.code," +
            "ot.order.employee.code, ot.order.code," +
            "ot.ticket.chair.name, ot.ticket.chair.chairType.name, ot.ticket.status," +
            " ot.ticket.createdTime, ot.ticket.id, ot.ticket.showTime.room.name, ot.ticket.showTime.time, " +
            "ot.ticket.showTime.movie.name)" +
            " FROM OrderTicket ot WHERE ot.order.id = :idOrders" +
            " ORDER BY ot.ticket.createdTime DESC")
    Page<TicketResponse> getTicketByOrdersId(@Param("idOrders") Long IdOrders, Pageable pageable);

    @Query("SELECT NEW com.example.be.employee.message.response.TicketResponse" +
            "(ot.price, ot.ticket.code, ot.order.customer.code," +
            "ot.order.employee.code, ot.order.code," +
            "ot.ticket.chair.name, ot.ticket.chair.chairType.name, ot.ticket.status," +
            " ot.ticket.createdTime, ot.ticket.id, ot.ticket.showTime.room.name," +
            " ot.ticket.showTime.time, ot.ticket.showTime.movie.name)" +
            "   FROM OrderTicket ot WHERE ot.order.customer.code = :customerCode" +
            " ORDER BY ot.ticket.createdTime DESC")
    Page<TicketResponse> getTicketByCodeCustomer(@Param("customerCode") String customerCode, Pageable pageable);

//    @Query("SELECT NEW com.example.be.employee.message.response.TicketResponse" +
//            "(ot.price, ot.ticket.code, ot.order.customer.code," +
//            "ot.order.employee.code, ot.order.code," +
//            "ot.ticket.chair.name, ot.ticket.chair.chairType.name, ot.ticket.status," +
//            "ot.ticket.createdTime, ot.ticket.id, ot.ticket.showTime.room.name," +
//            "ot.ticket.showTime.time, ot.ticket.showTime.movie.name)" +
//            "FROM OrderTicket ot WHERE ot.order.customer.code LIKE CONCAT('%', :customerCode, '%') " +
//            "OR ot.order.customer.phoneNumber LIKE CONCAT('%', :phoneNumber, '%')" +
//            "ORDER BY ot.ticket.createdTime DESC")
//    Page<TicketResponse> findTicketsByCustomerCode(@Param("customerCode") String customerCode);

}
