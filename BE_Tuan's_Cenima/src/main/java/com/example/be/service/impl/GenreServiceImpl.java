package com.example.be.service.impl;

import com.example.be.entity.Directors;
import com.example.be.entity.Genre;
import com.example.be.repository.DirectorsRepository;
import com.example.be.repository.GenreRepository;
import com.example.be.service.DirectorsService;
import com.example.be.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Page<Genre> getAll(int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, 15);

        return genreRepository.findAll(pageable);
    }

    @Override
    public Genre getOneById(Long id) {
        return genreRepository.findById(id).get();
    }

    @Override
    public Object saveOrUpdate(Genre genre) {
        return genreRepository.save(genre);
    }
}
