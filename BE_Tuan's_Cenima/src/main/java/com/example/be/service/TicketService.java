package com.example.be.service;

import com.example.be.employee.message.request.TicketRequest;
import com.example.be.employee.message.response.TicketResponse;
import com.example.be.entity.Ticket;
import org.springframework.data.domain.Page;

public interface TicketService {
    TicketResponse save(TicketRequest ticketRequest);

    Page<TicketResponse> getAll(Integer pageNo);

    //get 1 ticket
    TicketResponse getTicket(Long idTicket);

    Page<TicketResponse> getTicketByStatus(Integer status, Integer pageNo);

    Page<TicketResponse> getTicketByOrdersId(Long IdOrders, Integer pageNo);

    Page<TicketResponse> getTicketByCodeCustomer(String customerCode, Integer pageNo);

    Page<TicketResponse> searchTicket(
            String inputSearch,
            Integer pageNo
    );

    Ticket getOne(Long id);

    TicketResponse updateStatusTicket(Long idTicket, Integer status);

}
