package com.example.be.customer.controller;

import com.example.be.entity.Actor;
import com.example.be.customer.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/get-all")
    public List<Actor> getAll() {
        return actorService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Actor actor) {
        actorService.saveOrUpdate(actor);
        return "Ok";
    }


}
