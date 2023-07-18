package com.example.be.service.impl;

import com.example.be.entity.Actor;
import com.example.be.repository.ActorRepository;
import com.example.be.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;


    @Override
    public Page<Actor> getAll(int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, 15);

        return actorRepository.findAll(pageable);
    }

    @Override
    public Actor getOneById(Long id) {
        return actorRepository.findById(id).get();
    }

    @Override
    public Object saveOrUpdate(Actor actor) {
        return actorRepository.save(actor);
    }
}
