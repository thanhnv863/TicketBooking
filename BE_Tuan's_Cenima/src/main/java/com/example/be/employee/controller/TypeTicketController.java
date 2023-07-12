package com.example.be.employee.controller;

import com.example.be.entity.TypeTicket;
import com.example.be.employee.message.request.TypeTicketRequest;
import com.example.be.service.TypeTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type-ticket")
public class TypeTicketController {
    @Autowired
    private TypeTicketService typeTicketService;

    @GetMapping("/get-all")
    public List<TypeTicket> getAll() {
        return typeTicketService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody TypeTicketRequest typeTicketRequest) {
        typeTicketService.save(typeTicketRequest);
        return "Ok";
    }

    @PutMapping("/update/{id}")
    public String update(
            @PathVariable("id") Long id,
            @RequestBody TypeTicketRequest typeTicketRequest
    ) {
        typeTicketService.updateTypeTicket(id, typeTicketRequest);
        return "Ok";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        typeTicketService.deleteTypeTicket(id);
        return "Ok";
    }
}
