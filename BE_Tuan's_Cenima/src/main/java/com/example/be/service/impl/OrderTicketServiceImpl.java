package com.example.be.service.impl;

import com.example.be.entity.OrderTicket;
import com.example.be.repository.OrderTicketRepository;
import com.example.be.employee.message.request.OrderTicketRequest;
import com.example.be.service.OrderTicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderTicketServiceImpl implements OrderTicketService {
    @Autowired
    private OrderTicketRepository orderTicketRepository;

    @Override
    public Page<OrderTicket> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        return orderTicketRepository.findAll(pageable);
    }

    @Override
    public OrderTicket getOne(Long id) {
        return orderTicketRepository.findById(id).get();
    }
    @Transactional
    @Override
    public OrderTicket add(OrderTicketRequest orderTicketRequest) {
        OrderTicket orderTicket = OrderTicket.builder()
                .order(orderTicketRequest.getOrder())
                .ticket(orderTicketRequest.getTicket())
                .price(orderTicketRequest.getPrice())
                .note(orderTicketRequest.getNote())
                .status(1)
                .build();
        return orderTicketRepository.save(orderTicket);
    }
    @Transactional
    @Override
    public OrderTicket update(Long id, OrderTicketRequest orderTicketRequest) {
        OrderTicket orderTicket = orderTicketRepository.findById(id).get();
        orderTicket.setId(id);
        orderTicket.setPrice(orderTicketRequest.getPrice());
        orderTicket.setNote(orderTicketRequest.getNote());
        orderTicket.setStatus(orderTicketRequest.getStatus());
        return orderTicketRepository.save(orderTicket);
    }

    @Override
    public Boolean delete(Long id) {
        OrderTicket orderTicket = orderTicketRepository.findById(id).get();
        if (orderTicket == null) {
            return false;
        } else {
            orderTicketRepository.deleteById(id);
            return true;
        }
    }
}
