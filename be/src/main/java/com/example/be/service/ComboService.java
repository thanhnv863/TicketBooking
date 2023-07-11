package com.example.be.service;

import com.example.be.entity.Combo;
import com.example.be.request.ComboRequest;

import java.util.HashMap;
import java.util.List;

public interface ComboService {

    List<Combo> findAll();

    HashMap<String, Object> add(ComboRequest comboRequest);

    HashMap<String, Object> update(ComboRequest comboRequest, Long id);

    HashMap<String, Object> remove(Long id);

}
