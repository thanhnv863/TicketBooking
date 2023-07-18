package com.example.be.service;

import com.example.be.entity.Actor;
import com.example.be.entity.Genre;
import org.springframework.data.domain.Page;

public interface GenreService {

    Page<Genre> getAll(int pageNumber);

    Genre getOneById(Long id);

    Object saveOrUpdate(Genre genre);

}
