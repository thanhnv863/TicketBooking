package com.example.be.customer.service;

import com.example.be.entity.Genre;
import com.example.be.entity.Producer;

import java.util.List;

public interface ProducerService {

    List<Producer> getAll();

    void saveOrUpdate(Producer producer);

}
