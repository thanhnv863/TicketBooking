package com.example.be.controller;

import com.example.be.entity.SalePayment;
import com.example.be.request.SalePaymentRequest;
import com.example.be.service.impl.SalePaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale-payment")
public class SalePaymentController {
    @Autowired
    private SalePaymentServiceImpl salePaymentService;

    @GetMapping("/get-all")
    public List<SalePayment> getAll() {
        return salePaymentService.getAll();
    }

    @GetMapping("/get-one/{id}")
    public ResponseEntity<SalePayment> getOne(@PathVariable("id") Long id) {
        SalePayment salePayment = salePaymentService.getOne(id);
        if (salePayment != null) {
            return ResponseEntity.ok(salePayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<SalePayment> add(@RequestBody SalePaymentRequest salePaymentRequest) {
        SalePayment salePayment = salePaymentService.add(salePaymentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(salePayment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SalePayment> update(@PathVariable("id") Long id, @RequestBody SalePaymentRequest salePaymentRequest) {
        SalePayment salePayment = salePaymentService.update(id, salePaymentRequest);
        if (salePayment != null) {
            return ResponseEntity.ok(salePayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        boolean delete = salePaymentService.delete(id);
        if (delete) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
