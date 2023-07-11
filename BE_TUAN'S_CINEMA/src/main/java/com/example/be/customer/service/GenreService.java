package com.example.be.customer.service;

import com.example.be.entity.Actor;
import com.example.be.entity.Genre;

import java.util.List;

public interface GenreService {


    List<Genre> getAll();

    void saveOrUpdate(Genre genre);

}
