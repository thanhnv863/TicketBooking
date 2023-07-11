package com.example.be.customer.service;

import com.example.be.entity.Actor;
import com.example.be.entity.Directors;

import java.util.List;

public interface DirectorService {

    List<Directors> getAll();

    void saveOrUpdate(Directors directors);

}
