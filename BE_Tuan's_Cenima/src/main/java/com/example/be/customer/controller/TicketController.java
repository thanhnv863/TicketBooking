package com.example.be.customer.controller;

import com.example.be.entity.Ticket;
import com.example.be.employee.message.request.TicketRequest;
import com.example.be.employee.message.response.TicketResponse;
import com.example.be.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("user_ticket")
@RequestMapping("/user/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/save")
    public String save(@RequestBody TicketRequest ticketRequest) {
        ticketService.save(ticketRequest);
        return "Ok";
    }

    @GetMapping("/get-all")
    public List<Ticket> getAll() {
        return ticketService.getAll();
    }

    @GetMapping("/get-ticket/{id}")
    public TicketResponse getTicket(@PathVariable("id") Long id) {
        return ticketService.getTicket(id);
    }
}
