package com.example.be.controller;

import com.example.be.entity.Chair;
import com.example.be.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chair")
public class ChairController {
    @Autowired
    private ChairService chairService;

    @GetMapping("/get-all")
    public List<Chair> getAll() {
        return chairService.getAll();
    }
}
