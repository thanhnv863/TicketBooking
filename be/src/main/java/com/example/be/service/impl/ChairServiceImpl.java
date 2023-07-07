package com.example.be.service.impl;

import com.example.be.entity.Chair;
import com.example.be.repository.ChairRepository;
import com.example.be.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairServiceImpl implements ChairService {
    @Autowired
    private ChairRepository chairRepository;

    @Override
    public List<Chair> getAll() {
        return chairRepository.findAll();
    }
}
