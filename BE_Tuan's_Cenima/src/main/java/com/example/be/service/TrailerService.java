package com.example.be.service;

import com.example.be.entity.Actor;
import com.example.be.entity.Trailer;
import org.springframework.data.domain.Page;

public interface TrailerService {

    Page<Trailer> getAll(int pageNumber);

    Trailer getOneById(Long id);

    Object saveOrUpdate(Trailer trailer);

}
