package com.example.be.customer.controller;

import com.example.be.employee.message.request.ComboDetailRequest;
import com.example.be.service.ComboDetailService;
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

@RestController("user_combo_detail")
@RequestMapping("/user/combo-detail")
public class ComboDetailController {
    @Autowired
    private ComboDetailService comboDetailService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> map = DataUltil.setData("OK", comboDetailService.findAll());
        return ResponseEntity.ok(map);
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody ComboDetailRequest comboDetailRequest) {
        HashMap<String, Object> map = comboDetailService.add(comboDetailRequest);
        return ResponseEntity.ok(map);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody ComboDetailRequest comboDetailRequest, @PathVariable String id) {
        HashMap<String, Object> map = comboDetailService.update(comboDetailRequest, Long.valueOf(id));
        return ResponseEntity.ok(map);
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        HashMap<String, Object> map = comboDetailService.remove(Long.valueOf(id));
        return ResponseEntity.ok(map);
    }
}
