package com.example.be.service;

import com.example.be.entity.OrderTicket;
import com.example.be.employee.message.request.OrderTicketRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderTicketService {
    Page<OrderTicket> getAll(Integer pageNo);

    OrderTicket getOne(Long id);

    OrderTicket add(OrderTicketRequest orderTicketRequest);

    OrderTicket update(Long id, OrderTicketRequest orderTicketRequest);

    Boolean delete(Long id);

    List<OrderTicket> listOrderTicketByIdOrder(Long id);
}
