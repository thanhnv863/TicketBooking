package com.example.be.service;

import com.example.be.employee.message.request.OrderRequest;
import com.example.be.entity.Order;
import org.springframework.data.domain.Page;

import java.sql.Date;
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

    Page<Order> searchDate(Date dateFirst, Date dateLast, Integer pageNo);

    List<Order> getAllList();

}
