package com.example.be.employee.controller;

import com.example.be.entity.Actor;
import com.example.be.entity.Genre;
import com.example.be.service.ActorService;
import com.example.be.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/get-all")
    public Page<Genre> getAll(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber) {
        return genreService.getAll(pageNumber);
    }

    @GetMapping("/get-one-by-id/{id}")
    public Genre getOneByid(@PathVariable("id") Long id) {
        return genreService.getOneById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Genre genre) {
        return new ResponseEntity<>(genreService.saveOrUpdate(genre), HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Genre genre) {
        return new ResponseEntity<>(genreService.saveOrUpdate(genre), HttpStatus.ACCEPTED);
    }

}
