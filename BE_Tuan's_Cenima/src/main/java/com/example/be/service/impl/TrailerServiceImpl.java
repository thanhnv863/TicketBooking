package com.example.be.service.impl;

import com.example.be.entity.Trailer;
import com.example.be.repository.TrailerRepository;
import com.example.be.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrailerServiceImpl implements TrailerService {

    @Autowired
    private TrailerRepository trailerRepository;


    @Override
    public Page<Trailer> getAll(int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, 15);

        return trailerRepository.findAll(pageable);
    }

    @Override
    public Trailer getOneById(Long id) {
        return trailerRepository.findById(id).get();
    }

    @Override
    public Trailer saveOrUpdate(Trailer trailer) {
        return trailerRepository.save(trailer);
    }
}
