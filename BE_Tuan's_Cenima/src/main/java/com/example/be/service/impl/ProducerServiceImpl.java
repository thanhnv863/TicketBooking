package com.example.be.service.impl;

import com.example.be.entity.Directors;
import com.example.be.entity.Producer;
import com.example.be.repository.DirectorsRepository;
import com.example.be.repository.ProducerRepository;
import com.example.be.service.DirectorsService;
import com.example.be.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public Page<Producer> getAll(int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, 15);

        return producerRepository.findAll(pageable);
    }

    @Override
    public Producer getOneById(Long id) {
        return producerRepository.findById(id).get();
    }

    @Override
    public Object saveOrUpdate(Producer producer) {
        return producerRepository.save(producer);
    }
}
