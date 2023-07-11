package com.example.be.service.impl;

import com.example.be.entity.Order;
import com.example.be.repository.OrderRepository;
import com.example.be.employee.message.request.OrderRequest;
import com.example.be.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Page<Order> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 10);
        return orderRepository.findAll(pageable);
    }

    @Override
    public Order getOne(Long id) {
        return orderRepository.findById(id).get();
    }
    @Transactional
    @Override
    public Order add(OrderRequest orderRequest) {
        Date date = new Date();
        Order order = Order.builder().code(orderRequest.getCode()).totalAmount(orderRequest.getTotalAmount()).totalAfterReduction(orderRequest.getTotalAfterReduction()).status(orderRequest.getStatus()).createdBy(orderRequest.getCreatedBy()).createdTime(date).customer(orderRequest.getCustomer()).employee(orderRequest.getEmployee()).orderDate(date).timeOrder(date).build();
        return orderRepository.save(order);
    }
    @Transactional
    @Override
    public Order update(Long id, OrderRequest orderRequest) {
        Date date = new Date();
        Order order = orderRepository.findById(id).get();
        order.setId(id);
        order.setCode(orderRequest.getCode());
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setTotalAfterReduction(orderRequest.getTotalAfterReduction());
        order.setStatus(orderRequest.getStatus());
        order.setCreatedBy(orderRequest.getCreatedBy());
        order.setCreatedTime(order.getCreatedTime());
        order.setCustomer(orderRequest.getCustomer());
        order.setEmployee(orderRequest.getEmployee());
        order.setOrderDate(order.getOrderDate());
        order.setTimeOrder(order.getTimeOrder());
        order.setUpdatedTime(date);
        order.setUpdatedBy(orderRequest.getUpdatedBy());
        return orderRepository.save(order);
    }

    @Override
    public boolean delete(Long id) {
        Order order = orderRepository.findById(id).get();
        if (order == null) {
            return false;
        } else {
            orderRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public Order deleteSoft(Long id, OrderRequest orderRequest) {
        Date date = new Date();
        Order order = orderRepository.findById(id).get();
        order.setStatus(3);
        order.setUpdatedTime(date);
//        order.setUpdatedBy(orderRequest.getUpdatedBy());
        return orderRepository.save(order);
    }

    @Override
    public Page<Order> findAllByStatus(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 10);
        return orderRepository.findOrderStatus(pageable);
    }

    @Override
    public Page<Order> sortDescendingDate(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 10);
        return orderRepository.sortDescending(pageable);
    }

    @Override
    public Page<Order> sortUpDate(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 10);
        return orderRepository.sortUp(pageable);
    }

    @Override
    public Page<Order> sortDescendingTime(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 10);
        return orderRepository.sortDescendingTime(pageable);
    }

    @Override
    public Page<Order> sortUpTime(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 10);
        return orderRepository.sortUpTime(pageable);
    }
}
