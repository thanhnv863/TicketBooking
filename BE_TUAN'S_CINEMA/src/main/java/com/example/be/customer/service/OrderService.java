package com.example.be.customer.service;

import com.example.be.entity.Order;
import com.example.be.customer.message.request.OrderRequest;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    Order getOne(Long id);

    Order add(OrderRequest orderRequest);

    Order update(Long id, OrderRequest orderRequest);

    boolean delete(Long id);

    Order deleteSoft(Long id, OrderRequest orderRequest);

    List<Order> findAllByStatus();
}
