package com.example.be.employee.controller;

import com.example.be.entity.Actor;
import com.example.be.entity.Image;
import com.example.be.service.ActorService;
import com.example.be.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/get-all")
    public Page<Image> imageService(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber) {
        return imageService.getAll(pageNumber);
    }

    @GetMapping("/get-one-by-id/{id}")
    public Image getOneByid(@PathVariable("id") Long id) {
        return imageService.getOneById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Image image) {
        return new ResponseEntity<>(imageService.saveOrUpdate(image), HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Image image) {
        return new ResponseEntity<>(imageService.saveOrUpdate(image), HttpStatus.ACCEPTED);
    }

}
