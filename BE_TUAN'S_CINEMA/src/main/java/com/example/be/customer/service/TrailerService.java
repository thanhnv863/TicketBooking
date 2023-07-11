package com.example.be.customer.service;

import com.example.be.entity.Actor;
import com.example.be.entity.Trailer;

import java.util.List;

public interface TrailerService {


    List<Trailer> getAll();

    void saveOrUpdate(Trailer trailer);

}
