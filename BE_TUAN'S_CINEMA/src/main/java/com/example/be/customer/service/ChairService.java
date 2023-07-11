package com.example.be.customer.service;

import com.example.be.customer.message.request.ChairRequest;
import com.example.be.customer.message.response.ChairResponse;
import org.springframework.data.domain.Page;

public interface ChairService {
    Page<ChairResponse> getAll(Integer pageNo);

    void save(ChairRequest chairRequest);

    void delete(Long id);

    void update(Long id, ChairRequest chairRequest);
}
