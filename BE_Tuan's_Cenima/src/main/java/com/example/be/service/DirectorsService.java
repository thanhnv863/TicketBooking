package com.example.be.service;

import com.example.be.entity.Actor;
import com.example.be.entity.Directors;
import org.springframework.data.domain.Page;

public interface DirectorsService {

    Page<Directors> getAll(int pageNumber);

    Directors getOneById(Long id);

    Object saveOrUpdate(Directors directors);

}
