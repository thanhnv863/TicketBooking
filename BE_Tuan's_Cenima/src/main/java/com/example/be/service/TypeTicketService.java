package com.example.be.service;

import com.example.be.entity.TypeTicket;
import com.example.be.employee.message.request.TypeTicketRequest;

import java.util.List;

public interface TypeTicketService {
    List<TypeTicket> getAll();

    void save(TypeTicketRequest typeTicketRequest);

    void updateTypeTicket(Long id, TypeTicketRequest typeTicketRequest);

    void deleteTypeTicket(Long id);

}
