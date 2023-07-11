package com.example.be.customer.service.impl;

import com.example.be.customer.service.TrailerService;
import com.example.be.entity.Trailer;
import com.example.be.repository.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailerServiceImpl implements TrailerService {

    @Autowired
    private TrailerRepository repository;

    @Override
    public List<Trailer> getAll() {
        return repository.findAll();
    }

    @Override
    public void saveOrUpdate(Trailer trailer) {
        repository.save(trailer);
    }
}
