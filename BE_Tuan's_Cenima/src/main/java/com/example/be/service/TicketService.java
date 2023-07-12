package com.example.be.service;

import com.example.be.entity.Ticket;
import com.example.be.employee.message.request.TicketRequest;
import com.example.be.employee.message.response.TicketResponse;

import java.util.List;

public interface TicketService {
    void save(TicketRequest ticketRequest);

    List<Ticket> getAll();

    //get 1 ticket
    TicketResponse getTicket(Long idTicket);
}
