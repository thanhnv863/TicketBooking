package com.example.be.service;

import com.example.be.entity.Ticket;
import com.example.be.request.TicketRequest;
import com.example.be.response.TicketResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketService {
    void save(TicketRequest ticketRequest);

    List<Ticket> getAll();

    //get 1 ticket
    TicketResponse getTicket(Long idTicket);
}
