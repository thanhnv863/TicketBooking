package com.example.be.customer.service;

import com.example.be.entity.Actor;
import com.example.be.entity.MovieActor;

import java.util.List;

public interface ActorService {


    List<Actor> getAll();

    void saveOrUpdate(Actor actor);

}
