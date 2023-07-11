package com.example.be.customer.controller;

import com.example.be.entity.Producer;
import com.example.be.customer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/get-all")
    public List<Producer> getAll() {
        return producerService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Producer producer) {
        producerService.saveOrUpdate(producer);
        return "Ok";
    }

}
