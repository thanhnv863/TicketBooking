package com.example.be.customer.controller;

import com.example.be.employee.message.request.SnackTypeRequest;
import com.example.be.service.SnackTypeService;
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

@RestController("user_snack-type")
@RequestMapping("/user/snack-type")
public class SnackTypeController {

    @Autowired
    private SnackTypeService snackTypeService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> map = DataUltil.setData("OK", snackTypeService.findAll());
        return ResponseEntity.ok(map);
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody SnackTypeRequest snackTypeRequest) {
        HashMap<String, Object> map = snackTypeService.save(snackTypeRequest);
        return ResponseEntity.ok(map);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody SnackTypeRequest snackTypeRequest, @PathVariable String id) {
        HashMap<String, Object> map = snackTypeService.update(snackTypeRequest,Long.valueOf(id));
        return ResponseEntity.ok(map);
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        HashMap<String, Object> map = snackTypeService.remove(Long.valueOf(id));
        return ResponseEntity.ok(map);
    }
}
