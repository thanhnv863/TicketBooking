package com.example.be.service.impl;

import com.example.be.entity.OrderSnack;
import com.example.be.repository.OrderSnackRepository;
import com.example.be.employee.message.request.OrderSnackRequest;
import com.example.be.service.OrderSnackService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderSnackServiceImpl implements OrderSnackService {
    @Autowired
    private OrderSnackRepository orderSnackRepository;

    @Override
    public Page<OrderSnack> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        return orderSnackRepository.findAll(pageable);
    }

    @Override
    public OrderSnack getOne(Long id) {
        return orderSnackRepository.findById(id).get();
    }
    @Transactional
    @Override
    public OrderSnack add(OrderSnackRequest orderSnackRequest) {
        OrderSnack orderSnack = OrderSnack.builder()
                .order(orderSnackRequest.getOrder())
                .snacks(orderSnackRequest.getSnacks())
                .price(orderSnackRequest.getPrice())
                .quanitty(orderSnackRequest.getQuanitty())
                .note(orderSnackRequest.getNote())
                .status(1)
                .build();
        return orderSnackRepository.save(orderSnack);
    }

    @Transactional
    @Override
    public OrderSnack update(Long id, OrderSnackRequest orderSnackRequest) {
        OrderSnack orderSnack = orderSnackRepository.findById(id).get();
        orderSnack.setId(id);
        orderSnack.setPrice(orderSnackRequest.getPrice());
        orderSnack.setQuanitty(orderSnackRequest.getQuanitty());
        orderSnack.setNote(orderSnackRequest.getNote());
        orderSnack.setStatus(orderSnackRequest.getStatus());
        return orderSnackRepository.save(orderSnack);
    }

    @Override
    public Boolean delete(Long id) {
        OrderSnack orderSnack = orderSnackRepository.findById(id).get();
        if (orderSnack == null) {
            return false;
        } else {
            orderSnackRepository.deleteById(id);
            return true;
        }
    }
}
