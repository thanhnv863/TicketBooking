package com.example.be.employee.controller;

import com.example.be.entity.Actor;
import com.example.be.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/get-all")
    public Page<Actor> getAll(@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return actorService.getAll(pageNumber);
    }

    @GetMapping("/get-one-by-id/{id}")
    public Actor getOneByid(@PathVariable("id") Long id) {
        return actorService.getOneById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Actor actor) {
        return new ResponseEntity<>(actorService.saveOrUpdate(actor), HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Actor actor) {
        return new ResponseEntity<>(actorService.saveOrUpdate(actor), HttpStatus.ACCEPTED);
    }

}
