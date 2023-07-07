package com.example.be.controller;

import com.example.be.entity.Order;
import com.example.be.request.OrderRequest;
import com.example.be.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ObjectMapper objectMapper;

    //getAll
    @GetMapping("/get-all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    //findAllStatus
    @GetMapping("/get-all-status")
    @ResponseBody
    public ResponseEntity<String> getAllStatus() {
        List<Order> order = orderService.findAllByStatus();
//        List<OrderRequest> listOrder = new ArrayList<>();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        for (Order order1 : order) {
//            OrderRequest orderRequest = new OrderRequest();
//            orderRequest.setStatus(order1.getStatus());
//            //chuyển đổi sang dateTime;
//            LocalDateTime createdDateTime = LocalDateTime.ofInstant(order1.getCreatedTime().toInstant(), ZoneId.systemDefault());
//            String createdTimeFormatted = createdDateTime.format(formatter);
//            orderRequest.setCreatedTime(createdTimeFormatted);
//            listOrder.add(orderRequest);
//        }
        String jsonOrders;
        try {
            jsonOrders = objectMapper.writeValueAsString(order);

        } catch (JsonProcessingException e) {
            // Xử lý ngoại lệ khi chuyển đổi JSON
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(jsonOrders);
    }

    //getOne
    @GetMapping("/get-one/{id}")
    public ResponseEntity<Order> getUserById(@PathVariable Long id) {
        Order order = orderService.getOne(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Add
    @PostMapping("/save")
    public ResponseEntity<Order> add(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.add(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    //Update
    @PutMapping("/update/{id}")
    public ResponseEntity<Order> update(@PathVariable("id") Long id, @RequestBody OrderRequest orderRequest) {
        Order order = orderService.update(id, orderRequest);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
//        boolean delete = orderService.delete(id);
//        if (delete) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    //DeleteSoft
    @PutMapping("/delete/{id}")
    public ResponseEntity<Order> deleteSoft(@PathVariable("id") Long id, @RequestBody OrderRequest orderRequest) {
        Order order = orderService.deleteSoft(id, orderRequest);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
