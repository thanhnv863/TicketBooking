package com.example.be.customer.controller;

import com.example.be.employee.message.request.EmployeeRequest;
import com.example.be.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> map = DataUltil.setData("OK", employeeService.findAll());
        return ResponseEntity.ok(map);
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody EmployeeRequest employeeRequest) {
        HashMap<String, Object> map = employeeService.add(employeeRequest);
        return ResponseEntity.ok(map);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody EmployeeRequest employeeRequest) {
        HashMap<String, Object> map = employeeService.update(employeeRequest, Long.valueOf(id));
        return ResponseEntity.ok(map);
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        HashMap<String, Object> map = employeeService.remove(Long.valueOf(id));
        return ResponseEntity.ok(map);
    }
}
