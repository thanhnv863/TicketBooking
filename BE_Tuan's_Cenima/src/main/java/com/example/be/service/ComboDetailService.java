package com.example.be.service;

import com.example.be.entity.ComboDetail;
import com.example.be.employee.message.request.ComboDetailRequest;

import java.util.HashMap;
import java.util.List;

public interface ComboDetailService {

    List<ComboDetail> findAll();

    HashMap<String, Object> add(ComboDetailRequest comboDetailRequest);

    HashMap<String, Object> update(ComboDetailRequest comboDetailRequest, Long id);

    HashMap<String, Object> remove(Long id);

}
