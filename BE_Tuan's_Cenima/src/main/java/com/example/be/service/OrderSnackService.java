package com.example.be.service;

import com.example.be.employee.message.request.OrderSnackRequest;
import com.example.be.entity.OrderSnack;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderSnackService {
    Page<OrderSnack> getAll(Integer pageNo);

    OrderSnack getOne(Long id);

    OrderSnack add(OrderSnackRequest orderSnackRequest);

    OrderSnack update(Long id, OrderSnackRequest orderSnackRequest);

    Boolean delete(Long id);

    List<OrderSnack> listOrderSnackByIdOrder(Long id);
}
