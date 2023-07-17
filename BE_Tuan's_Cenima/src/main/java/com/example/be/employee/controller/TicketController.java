package com.example.be.employee.controller;

import com.example.be.employee.message.request.TicketRequest;
import com.example.be.employee.message.response.TicketResponse;
import com.example.be.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/save")
    public TicketResponse save(@RequestBody TicketRequest ticketRequest) {
        return ticketService.save(ticketRequest);
    }

    @GetMapping("/get-all")
    public Page<TicketResponse> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return ticketService.getAll(pageNo);
    }

    @GetMapping("/get-ticket/{id}")
    public TicketResponse getTicket(@PathVariable("id") Long id) {
        return ticketService.getTicket(id);
    }

    @GetMapping("/get-ticket-by-status")
    public Page<TicketResponse> getTicketByStatus(
            @RequestParam("status") Integer status,
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        return ticketService.getTicketByStatus(status, pageNo);
    }

    @GetMapping("/get-ticket-by-id-orders")
    public Page<TicketResponse> getTicketByIdOrders(
            @RequestParam("idOrders") Long idOrders,
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        return ticketService.getTicketByOrdersId(idOrders, pageNo);
    }

    @GetMapping("/get-ticket-by-code-customer")
    public Page<TicketResponse> getTicketByCustomerCode(
            @RequestParam("customerCode") String customerCode,
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        return ticketService.getTicketByCodeCustomer(customerCode, pageNo);
    }
}
