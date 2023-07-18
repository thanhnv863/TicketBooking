package com.example.be.service.impl;

import com.example.be.employee.message.request.OrderRequest;
import com.example.be.entity.Order;
import com.example.be.entity.OrderTimeLine;
import com.example.be.repository.OrderRepository;
import com.example.be.repository.OrderTimeLineRepository;
import com.example.be.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderTimeLineRepository orderTimeLineRepository;

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
        Order orderAdd = orderRepository.save(order);
        OrderTimeLine orderTimeLine = OrderTimeLine.builder()
                .createdTime(date)
                .type("Created")
                .note("Nhân Viên Tạo Đơn Cho Khách")
                .order(orderAdd)
                .employee(orderAdd.getEmployee())
                .build();
        orderTimeLineRepository.save(orderTimeLine);
        return orderAdd;
    }

    @Transactional
    @Override
    public Order update(Long id, OrderRequest orderRequest) {
        Date date = new Date();
        Order order = orderRepository.findById(id).get();
        order.setId(id);
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setTotalAfterReduction(orderRequest.getTotalAfterReduction());
        order.setStatus(orderRequest.getStatus());
        order.setCreatedBy(orderRequest.getCreatedBy());
        order.setCustomer(orderRequest.getCustomer());
        order.setEmployee(orderRequest.getEmployee());
        order.setUpdatedTime(date);
        order.setUpdatedBy(orderRequest.getUpdatedBy());
        Order orderUpdate = orderRepository.save(order);
        OrderTimeLine orderTimeLine = OrderTimeLine.builder()
                .createdTime(date)
                .type((orderUpdate.getStatus() == 2 ? "Updated" : ""))
                .note("Update update")
                .order(orderUpdate)
                .employee(orderUpdate.getEmployee())
                .build();
        orderTimeLineRepository.save(orderTimeLine);
        return orderUpdate;
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

    @Override
    public Page<Order> searchDate(java.sql.Date dateFirst, java.sql.Date dateLast, Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 10);
        return orderRepository.searchDate(dateFirst, dateLast, pageable);
    }

    @Override
    public List<Order> getAllList() {
        return orderRepository.findAll();
    }


}
