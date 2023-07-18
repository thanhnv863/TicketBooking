package com.example.be.service;

import com.example.be.entity.Actor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActorService {

    Page<Actor> getAll(int pageNumber);

    Actor getOneById(Long id);

    Object saveOrUpdate(Actor actor);

}
