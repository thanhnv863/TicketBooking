package com.example.be.controller;

import com.example.be.entity.ChairType;
import com.example.be.request.ChairTypeRequest;
import com.example.be.service.ChairTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chair-type")
public class ChairTypeController {
    @Autowired
    private ChairTypeService chairTypeService;

    @GetMapping("/get-all")
    public List<ChairType> getAll() {
        return chairTypeService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody ChairTypeRequest chairTypeRequest) {
        chairTypeService.save(chairTypeRequest);
        return "Ok";
    }
}
