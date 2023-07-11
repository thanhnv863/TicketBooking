package com.example.be.customer.service.impl;

import com.example.be.customer.service.GenreService;
import com.example.be.entity.Genre;
import com.example.be.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository repository;

    @Override
    public List<Genre> getAll() {

        return repository.findAll();
    }

    @Override
    public void saveOrUpdate(Genre genre) {
        repository.save(genre);
    }
}
