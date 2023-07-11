package com.example.be.customer.controller;

import com.example.be.entity.Image;
import com.example.be.customer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/get-all")
    public List<Image> getAll() {
        return imageService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Image image) {
        imageService.saveOrUpdate(image);
        return "Ok";
    }


}
