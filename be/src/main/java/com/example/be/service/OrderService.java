package com.example.be.service;

import com.example.be.entity.Order;
import com.example.be.request.OrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    Page<Order> getAll(Integer pageNo);

    Order getOne(Long id);

    Order add(OrderRequest orderRequest);

    Order update(Long id, OrderRequest orderRequest);

    boolean delete(Long id);

    Order deleteSoft(Long id, OrderRequest orderRequest);

    Page<Order> findAllByStatus(Integer pageNo);

    Page<Order> sortDescendingDate(Integer pageNo);

    Page<Order> sortUpDate(Integer pageNo);

    Page<Order> sortDescendingTime(Integer pageNo);

    Page<Order> sortUpTime(Integer pageNo);

}
