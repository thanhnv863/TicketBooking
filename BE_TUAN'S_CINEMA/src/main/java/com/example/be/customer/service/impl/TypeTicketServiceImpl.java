package com.example.be.customer.service.impl;

import com.example.be.customer.service.TypeTicketService;
import com.example.be.entity.TypeTicket;
import com.example.be.repository.TypeTicketRepository;
import com.example.be.customer.message.request.TypeTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TypeTicketServiceImpl implements TypeTicketService {
    @Autowired
    private TypeTicketRepository typeTicketRepository;

    //0 - Ngung kinh doanh, 1 - Dang kinh doanh
    @Override
    public List<TypeTicket> getAll() {
        return typeTicketRepository.findAll();
    }

    @Override
    public void save(TypeTicketRequest typeTicketRequest) {
        TypeTicket typeTicket = TypeTicket.builder()
                .name(typeTicketRequest.getName())
                .createdBy("NV001")
                .status(1)
                .createdTime(new Date())
                .build();
        typeTicketRepository.save(typeTicket);
    }

    @Override
    public void updateTypeTicket(Long id, TypeTicketRequest typeTicketRequest) {
        TypeTicket typeTicket = typeTicketRepository.findById(id).get();
        typeTicket.setName(typeTicketRequest.getName());
        typeTicket.setUpdatedBy("NV001");
        typeTicket.setStatus(typeTicketRequest.getStatus());
        typeTicket.setUpdatedTime(new Date());
        typeTicketRepository.save(typeTicket);
    }

    @Override
    public void deleteTypeTicket(Long id) {
        TypeTicket typeTicket = typeTicketRepository.findById(id).get();
        typeTicket.setUpdatedBy("NV001");
        typeTicket.setStatus(0);
        typeTicket.setUpdatedTime(new Date());
        typeTicketRepository.save(typeTicket);
    }
}
