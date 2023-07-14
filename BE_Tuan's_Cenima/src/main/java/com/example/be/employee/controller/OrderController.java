package com.example.be.employee.controller;

import com.example.be.employee.message.request.OrderRequest;
import com.example.be.entity.Order;
import com.example.be.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
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
    public Page<Order> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return orderService.getAll(pageNo);
    }
    @GetMapping("/get-all-list")
    public List<Order> getAllList() {
        return orderService.getAllList();
    }
    //findAllStatus
    @GetMapping("/get-all-status")
    public Page<Order> getAllStatus(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return orderService.findAllByStatus(pageNo);
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

    @GetMapping("/sortDescendingDate")
    public Page<Order> sortDescendingDate(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return orderService.sortDescendingDate(pageNo);
    }

    @GetMapping("/sortUpDate")
    public Page<Order> sortUpDate(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return orderService.sortUpDate(pageNo);
    }

    @GetMapping("/sortUpTime")
    public Page<Order> sortUpTime(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return orderService.sortUpTime(pageNo);
    }

    @GetMapping("/sortDescendingTime")
    public Page<Order> sortDescendingTime(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return orderService.sortDescendingTime(pageNo);
    }

    @GetMapping("/searchDate")
    public Page<Order> searchDate(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                  @RequestParam("dateFirst") String dateFirst,
                                  @RequestParam("dateLast") String dateLast) {
        if (dateFirst == null || dateLast == null) {
            // Xử lý trường hợp giá trị null
            // ...
        }
        return orderService.searchDate(Date.valueOf(dateFirst), Date.valueOf(dateLast), pageNo);
    }

}
