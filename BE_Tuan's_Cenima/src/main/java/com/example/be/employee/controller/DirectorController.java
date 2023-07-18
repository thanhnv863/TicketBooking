package com.example.be.employee.controller;

import com.example.be.entity.Actor;
import com.example.be.entity.Directors;
import com.example.be.service.ActorService;
import com.example.be.service.DirectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/director")
public class DirectorController {


    @Autowired
    private DirectorsService directorsService;

    @GetMapping("/get-all")
    public Page<Directors> getAll(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber) {
        return directorsService.getAll(pageNumber);
    }

    @GetMapping("/get-one-by-id/{id}")
    public Directors getOneByid(@PathVariable("id") Long id) {
        return directorsService.getOneById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Directors directors) {
        return new ResponseEntity<>(directorsService.saveOrUpdate(directors), HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Directors directors) {
        return new ResponseEntity<>(directorsService.saveOrUpdate(directors), HttpStatus.ACCEPTED);
    }

}
