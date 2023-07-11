package com.example.be.service.impl;

import com.example.be.entity.Chair;
import com.example.be.entity.ChairType;
import com.example.be.entity.ShowTime;
import com.example.be.entity.Ticket;
import com.example.be.entity.TicketPrice;
import com.example.be.entity.TypeTicket;
import com.example.be.repository.ChairRepository;
import com.example.be.repository.ChairTypeRepository;
import com.example.be.repository.TicketPriceRepository;
import com.example.be.repository.TicketRepository;
import com.example.be.repository.TypeTicketRepository;
import com.example.be.employee.message.request.TicketRequest;
import com.example.be.employee.message.response.TicketResponse;
import com.example.be.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ChairTypeRepository chairTypeRepository;
    @Autowired
    private TypeTicketRepository typeTicketRepository;
    @Autowired
    private TicketPriceRepository ticketPriceRepository;
    @Autowired
    private ChairRepository chairRepository;

    //them xuat chieu nua

    @Override
    public void save(TicketRequest ticketRequest) {
        TypeTicket typeTicket = typeTicketRepository.findById(ticketRequest.getIdTypeTickket()).get();
        Chair chair = chairRepository.findById(ticketRequest.getIdChair()).get();
        ChairType chairType = chairTypeRepository.findById(chair.getChairType().getId()).get();
        TicketPrice ticketPrice = ticketPriceRepository.getTicketPriceByChairType_IdAndTypeTicket_Id(chairType.getId(), typeTicket.getId());
        ShowTime showTime = new ShowTime();
        showTime.setId(ticketRequest.getIdShowTime());
        Ticket ticket = Ticket.builder()
                .chair(chair)
                .createdBy("NV001")
                .createdTime(new Date())
                .ticketPrice(ticketPrice)
                .status(1)
                .typeTicket(typeTicket)
                .showTime(showTime)
                .code(ticketRequest.getCode())
                .ticketPrice(ticketPrice)
                .build();
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public TicketResponse getTicket(Long idTicket) {
        return ticketRepository.getTicket(idTicket);
    }
}
