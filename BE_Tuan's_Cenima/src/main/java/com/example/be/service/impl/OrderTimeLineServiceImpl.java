package com.example.be.service.impl;

import com.example.be.entity.OrderTimeLine;
import com.example.be.repository.OrderTimeLineRepository;
import com.example.be.service.OrderTimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTimeLineServiceImpl implements OrderTimeLineService {
    @Autowired
    private OrderTimeLineRepository orderTimeLineRepository;

    @Override
    public List<OrderTimeLine> getAll() {
        return orderTimeLineRepository.findAll();
    }

    @Override
    public List<OrderTimeLine> findAllTime() {
        return orderTimeLineRepository.getAllTime();
    }
}
