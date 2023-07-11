package com.example.be.customer.controller;

import com.example.be.employee.message.request.ComboRequest;
import com.example.be.service.ComboService;
import com.example.be.util.DataUltil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("combo")
public class ComboController {
    @Autowired
    private ComboService comboService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> map = DataUltil.setData("OK", comboService.findAll());
        return ResponseEntity.ok(map);
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody ComboRequest comboRequest) {
        HashMap<String, Object> map = comboService.add(comboRequest);
        return ResponseEntity.ok(map);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody ComboRequest comboRequest, @PathVariable String id) {
        HashMap<String, Object> map = comboService.update(comboRequest, Long.valueOf(id));
        return ResponseEntity.ok(map);
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        HashMap<String, Object> map = comboService.remove(Long.valueOf(id));
        return ResponseEntity.ok(map);
    }
}
