package com.example.be.service.impl;

import com.example.be.entity.Directors;
import com.example.be.repository.DirectorsRepository;
import com.example.be.service.DirectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorsService {

    @Autowired
    private DirectorsRepository directorsRepository;

    @Override
    public Page<Directors> getAll(int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, 15);

        return directorsRepository.findAll(pageable);
    }

    @Override
    public Directors getOneById(Long id) {
        return directorsRepository.findById(id).get();
    }

    @Override
    public Object saveOrUpdate(Directors directors) {
        return directorsRepository.save(directors);
    }
}
