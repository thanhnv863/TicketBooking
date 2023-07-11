package com.example.be.employee.controller;

import com.example.be.employee.message.request.OrderTicketRequest;
import com.example.be.entity.OrderTicket;
import com.example.be.service.impl.OrderTicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-ticket")
public class OrderTicketController {
    @Autowired
    private OrderTicketServiceImpl orderTicketService;

    @GetMapping("/get-all")
    public Page<OrderTicket> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return orderTicketService.getAll(pageNo);
    }

    @PostMapping("/save")
    public ResponseEntity<OrderTicket> add(@RequestBody OrderTicketRequest orderTicketRequest) {
        OrderTicket orderTicket = orderTicketService.add(orderTicketRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderTicket);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderTicket> update(@PathVariable("id") Long id, @RequestBody OrderTicketRequest orderTicketRequest) {
        OrderTicket orderTicket = orderTicketService.update(id, orderTicketRequest);
        if (orderTicket != null) {
            return ResponseEntity.ok(orderTicket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Boolean delete = orderTicketService.delete(id);
        if (delete) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
