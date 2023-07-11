package com.example.be.customer.controller;

import com.example.be.employee.message.response.TicketPriceResponse;
import com.example.be.entity.TicketPrice;
import com.example.be.employee.message.request.TicketPriceRequest;
import com.example.be.service.TicketPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket-price")
public class TicketPriceController {
    @Autowired
    private TicketPriceService ticketPriceService;

    @GetMapping("/get-all")
    public Page<TicketPriceResponse> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return ticketPriceService.getAll(pageNo);
    }

    @PostMapping("/save")
    public String save(@RequestBody TicketPriceRequest ticketPriceRequest) {
        ticketPriceService.save(ticketPriceRequest);
        return "Ok";
    }

    @PutMapping("/update/{id}")
    public String update(
            @PathVariable("id") Long id,
            @RequestBody TicketPriceRequest ticketPriceRequest
    ) {
        ticketPriceService.update(id, ticketPriceRequest);
        return "ok";
    }

    @GetMapping("/get-by-typeTicket-and-chairType")
    public TicketPrice getByTypeTicketAndChairType(
            @RequestParam("idTypeTicket") Long idTypeTicket,
            @RequestParam("idChairType") Long idChairType
    ) {
        return ticketPriceService.getTicketPriceByChairType_IdAndTypeTicket_Id(idChairType, idTypeTicket);
    }
}
