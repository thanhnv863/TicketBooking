package com.example.be.customer.controller;

import com.example.be.entity.Trailer;
import com.example.be.customer.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trailer")
public class TrailerController {

    @Autowired
    private TrailerService trailerService;

    @GetMapping("/get-all")
    public List<Trailer> getAll() {
        return trailerService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Trailer trailer) {
        trailerService.saveOrUpdate(trailer);
        return "Ok";
    }


}
