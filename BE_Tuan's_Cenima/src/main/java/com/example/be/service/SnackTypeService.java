package com.example.be.service;

import com.example.be.entity.SnackType;
import com.example.be.employee.message.request.SnackTypeRequest;

import java.util.HashMap;
import java.util.List;

public interface SnackTypeService {
    List<SnackType> findAll();

    HashMap<String, Object> save(SnackTypeRequest snackTypeRequest);

    HashMap<String, Object> update(SnackTypeRequest snackTypeRequest, Long id);

    HashMap<String, Object> remove(Long id);

}
