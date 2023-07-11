package com.example.be.service;

import com.example.be.entity.Snacks;
import com.example.be.request.SnackRequest;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface SnackService {

    List<Snacks> findAll();

    HashMap<String, Object> add(SnackRequest snackRequest);

    HashMap<String, Object> update(SnackRequest snackRequest, Long id);

    HashMap<String, Object> remove(Long id);

    Page<Snacks> phanTrang(Optional<Integer> optional);

}
