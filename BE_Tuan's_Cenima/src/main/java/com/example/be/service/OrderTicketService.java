package com.example.be.service;

import com.example.be.entity.OrderTicket;
import com.example.be.employee.message.request.OrderTicketRequest;
import org.springframework.data.domain.Page;

public interface OrderTicketService {
    Page<OrderTicket> getAll(Integer pageNo);

    OrderTicket getOne(Long id);

    OrderTicket add(OrderTicketRequest orderTicketRequest);

    OrderTicket update(Long id, OrderTicketRequest orderTicketRequest);

    Boolean delete(Long id);
}
