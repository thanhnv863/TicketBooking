package com.example.be.service;

import com.example.be.entity.Directors;
import com.example.be.entity.Producer;
import org.springframework.data.domain.Page;

public interface ProducerService {

    Page<Producer> getAll(int pageNumber);

    Producer getOneById(Long id);

    Object saveOrUpdate(Producer producer);

}
