package com.example.be.customer.controller;

import com.example.be.employee.message.request.OrderSnackRequest;
import com.example.be.entity.OrderSnack;
import com.example.be.service.impl.OrderSnackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("user_order-snack")
@RequestMapping("/user/order-snack")
public class OrderSnackController {
    @Autowired
    private OrderSnackServiceImpl orderSnackService;

    @GetMapping("/get-all")
    public Page<OrderSnack> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return orderSnackService.getAll(pageNo);
    }

    @PostMapping("/save")
    public ResponseEntity<OrderSnack> add(@RequestBody OrderSnackRequest orderSnackRequest) {
        OrderSnack orderSnack = orderSnackService.add(orderSnackRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderSnack);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderSnack> update(@PathVariable("id") Long id, @RequestBody OrderSnackRequest orderSnackRequest) {
        OrderSnack orderSnack = orderSnackService.update(id, orderSnackRequest);
        if (orderSnack != null) {
            return ResponseEntity.ok(orderSnack);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Boolean delete = orderSnackService.delete(id);
        if (delete) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
