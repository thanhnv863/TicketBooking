package com.example.be.service;

import com.example.be.entity.OrderTimeLine;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderTimeLineService {
    List<OrderTimeLine> getAll();

    List<OrderTimeLine> findAllTime();

    List<OrderTimeLine> getOneIdOrder(Long id);
}
