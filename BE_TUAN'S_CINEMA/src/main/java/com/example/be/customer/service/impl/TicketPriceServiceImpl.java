package com.example.be.customer.service.impl;

import com.example.be.entity.ChairType;
import com.example.be.entity.TicketPrice;
import com.example.be.entity.TypeTicket;
import com.example.be.repository.ChairTypeRepository;
import com.example.be.repository.TicketPriceRepository;
import com.example.be.repository.TypeTicketRepository;
import com.example.be.customer.message.request.TicketPriceRequest;
import com.example.be.customer.message.response.TicketPriceResponse;
import com.example.be.customer.service.TicketPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TicketPriceServiceImpl implements TicketPriceService {
    @Autowired
    private TicketPriceRepository ticketPriceRepository;

    @Autowired
    private TypeTicketRepository typeTicketRepository;
    @Autowired
    private ChairTypeRepository chairTypeRepository;

    @Override
    public Page<TicketPriceResponse> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<TicketPriceResponse> ticketPriceResponses = ticketPriceRepository.findAll(pageable).map(ticketPrice -> convertTicketPriceToRes(ticketPrice));
        return ticketPriceResponses;
    }

    @Override
    public void save(TicketPriceRequest ticketPriceRequest) {
        TypeTicket typeTicket = typeTicketRepository.findById(ticketPriceRequest.getIdTicketType()).get();
        ChairType chairType = chairTypeRepository.findById(ticketPriceRequest.getIdChairType()).get();
        TicketPrice ticketPrice = TicketPrice.builder()
                .typeTicket(typeTicket)
                .chairType(chairType)
                .price(ticketPriceRequest.getPrice())
                .createdBy("NV001")
                .createdTime(new Date())
                .build();
        ticketPriceRepository.save(ticketPrice);
    }

    @Override
    public void update(Long id, TicketPriceRequest ticketPriceRequest) {
        TicketPrice ticketPrice = ticketPriceRepository.findById(id).get();
        TypeTicket typeTicket = typeTicketRepository.findById(ticketPriceRequest.getIdTicketType()).get();
        ChairType chairType = chairTypeRepository.findById(ticketPriceRequest.getIdChairType()).get();
        ticketPrice.setPrice(ticketPriceRequest.getPrice());
        ticketPrice.setUpdatedBy("NV001");
        ticketPrice.setTypeTicket(typeTicket);
        ticketPrice.setUpdatedTime(new Date());
        ticketPrice.setChairType(chairType);
        ticketPriceRepository.save(ticketPrice);
    }

    @Override
    public TicketPrice getTicketPriceByChairType_IdAndTypeTicket_Id(Long chairTypeId, Long typeTicketId) {
        return ticketPriceRepository.getTicketPriceByChairType_IdAndTypeTicket_Id(chairTypeId, typeTicketId);
    }

    private TicketPriceResponse convertTicketPriceToRes(TicketPrice ticketPrice) {
        TicketPriceResponse ticketPriceResponse = TicketPriceResponse.builder()
                .nameTypeTicket(ticketPrice.getTypeTicket().getName())
                .nameTypeChair(ticketPrice.getChairType().getName())
                .price(ticketPrice.getPrice())
                .build();
        return ticketPriceResponse;
    }
}
