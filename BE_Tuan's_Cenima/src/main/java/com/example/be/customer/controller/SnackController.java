package com.example.be.customer.controller;

import com.example.be.employee.message.request.SnackRequest;
import com.example.be.service.SnackService;
import com.example.be.util.DataUltil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController("user_snack")
@RequestMapping("/user/snack")
public class SnackController {
    @Autowired
    private SnackService snackService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> map = DataUltil.setData("OK", snackService.findAll());
        return ResponseEntity.ok(map);
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> phanTrang(@RequestParam("pageNum") String pageNum) {
        Optional<Integer> optional = Optional.of(Integer.valueOf(pageNum));
        return ResponseEntity.ok(snackService.phanTrang(optional));
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody SnackRequest snackRequest) {
        HashMap<String, Object> map = snackService.add(snackRequest);
        return ResponseEntity.ok(map);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody SnackRequest snackRequest) {
        HashMap<String, Object> map = snackService.update(snackRequest, Long.valueOf(id));
        return ResponseEntity.ok(map);
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        HashMap<String, Object> map = snackService.remove(Long.valueOf(id));
        return ResponseEntity.ok(map);
    }
}
