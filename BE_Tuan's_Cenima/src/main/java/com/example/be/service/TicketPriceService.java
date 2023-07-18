package com.example.be.service;

import com.example.be.entity.TicketPrice;
import com.example.be.employee.message.request.TicketPriceRequest;
import com.example.be.employee.message.response.TicketPriceResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TicketPriceService {
    Page<TicketPriceResponse> getAll(Integer pageNo);

    void save(TicketPriceRequest ticketPriceRequest);

    void update(Long id, TicketPriceRequest ticketPriceRequest);

    TicketPrice getTicketPriceByChairType_IdAndTypeTicket_Id(Long chairTypeId, Long typeTicketId);

    List<TicketPrice> getAllEntity();

}
