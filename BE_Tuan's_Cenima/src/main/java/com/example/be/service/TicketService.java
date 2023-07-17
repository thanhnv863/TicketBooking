package com.example.be.service;

import com.example.be.employee.message.request.TicketRequest;
import com.example.be.employee.message.response.TicketResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface TicketService {
    TicketResponse save(TicketRequest ticketRequest);

    Page<TicketResponse> getAll(Integer pageNo);

    //get 1 ticket
    TicketResponse getTicket(Long idTicket);

    Page<TicketResponse> getTicketByStatus(Integer status, Integer pageNo);

    Page<TicketResponse> getTicketByOrdersId(Long IdOrders, Integer pageNo);

    Page<TicketResponse> getTicketByCodeCustomer(String customerCode, Integer pageNo);

}
