package com.example.be.customer.service;

import com.example.be.entity.ChairType;
import com.example.be.customer.message.request.ChairTypeRequest;

import java.util.List;

public interface ChairTypeService {
    void save(ChairTypeRequest chairTypeRequest);

    List<ChairType> getAll();

    void updateStatus(Long id, Integer status);
}
