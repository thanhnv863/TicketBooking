package com.example.be.customer.service.impl;

import com.example.be.customer.service.DirectorService;
import com.example.be.entity.Directors;
import com.example.be.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository repository;

    @Override
    public List<Directors> getAll() {
        return repository.findAll();
    }

    @Override
    public void saveOrUpdate(Directors directors) {
        repository.save(directors);
    }
}
