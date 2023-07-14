package com.example.be.employee.controller;

import com.example.be.entity.OrderTimeLine;
import com.example.be.service.impl.OrderTimeLineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-time-line")
public class OrderTimeLineController {
    @Autowired
    private OrderTimeLineServiceImpl orderTimeLineService;

    @GetMapping("/get-all")
    public List<OrderTimeLine> getAll() {
        return orderTimeLineService.getAll();
    }
}
