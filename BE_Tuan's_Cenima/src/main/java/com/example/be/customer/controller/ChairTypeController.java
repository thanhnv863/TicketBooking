package com.example.be.customer.controller;

import com.example.be.employee.message.request.ChairTypeRequest;
import com.example.be.entity.ChairType;
import com.example.be.service.ChairTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chair-type")
public class ChairTypeController {
    @Autowired
    private ChairTypeService chairTypeService;

    @GetMapping("/get-all")
    public List<ChairType> getAll() {
        return chairTypeService.getAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody ChairTypeRequest chairTypeRequest) {
        chairTypeService.save(chairTypeRequest);
        return "Ok";
    }

    @PostMapping("/update-status/{id}")
    public ResponseEntity<String> updateStatus(
            @PathVariable("id") Long id,
            @RequestParam("status") Integer status
    ) {
        chairTypeService.updateStatus(id, status);
        return ResponseEntity.ok("Ok");
    }
}
