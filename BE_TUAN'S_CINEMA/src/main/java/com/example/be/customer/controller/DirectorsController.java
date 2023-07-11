package com.example.be.customer.controller;

import com.example.be.entity.Directors;
import com.example.be.customer.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/derectors")
public class DirectorsController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/get-all")
    public List<Directors> getAll() {
        return directorService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Directors directors) {
        directorService.saveOrUpdate(directors);
        return "Ok";
    }

}
