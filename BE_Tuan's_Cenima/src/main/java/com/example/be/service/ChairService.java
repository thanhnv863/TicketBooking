package com.example.be.service;

import com.example.be.employee.message.request.ChairRequest;
import com.example.be.employee.message.response.ChairResponse;
import org.springframework.data.domain.Page;

public interface ChairService {
    Page<ChairResponse> getAll(Integer pageNo);

    void save(ChairRequest chairRequest);

    void delete(Long id);

    void update(Long id, ChairRequest chairRequest);
}
