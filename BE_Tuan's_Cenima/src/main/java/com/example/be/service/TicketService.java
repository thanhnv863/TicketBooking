package com.example.be.service;

import com.example.be.employee.message.request.TicketRequest;
import com.example.be.employee.message.response.TicketResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TicketService {
    TicketResponse save(TicketRequest ticketRequest);

    Page<TicketResponse> getAll(Integer pageNo);

    //get 1 ticket
    TicketResponse getTicket(Long idTicket);

}
