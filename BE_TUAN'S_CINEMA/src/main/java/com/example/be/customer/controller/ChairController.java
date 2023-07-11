package com.example.be.customer.controller;

import com.example.be.customer.message.request.ChairRequest;
import com.example.be.customer.message.response.ChairResponse;
import com.example.be.customer.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

@RestController
@RequestMapping("/chair")
public class ChairController {
    @Autowired
    private ChairService chairService;

    @GetMapping("/get-all")
    public Page<ChairResponse> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        return chairService.getAll(pageNo);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ChairRequest chairRequest) {
        chairService.save(chairRequest);
        return ResponseEntity.ok("Ok");
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        chairService.delete(id);
        return "OK";
    }

    @PutMapping("/update/{id}")
    public String update(
            @PathVariable("id") Long id,
            @RequestBody ChairRequest chairRequest
    ) {
        chairService.update(id, chairRequest);
        return "Ok";
    }

}
