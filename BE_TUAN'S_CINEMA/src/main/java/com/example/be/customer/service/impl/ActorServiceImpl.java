package com.example.be.customer.service.impl;

import com.example.be.customer.service.ActorService;
import com.example.be.entity.Actor;
import com.example.be.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository repository;

    @Override
    public List<Actor> getAll() {
        return repository.findAll();
    }

    @Override
    public void saveOrUpdate(Actor actor) {
        repository.save(actor);
    }
}
