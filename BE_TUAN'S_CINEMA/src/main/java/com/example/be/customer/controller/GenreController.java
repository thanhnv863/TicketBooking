package com.example.be.customer.controller;

import com.example.be.entity.Genre;
import com.example.be.customer.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/get-all")
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Genre genre) {
        genreService.saveOrUpdate(genre);
        return "Ok";
    }

}
