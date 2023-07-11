package com.example.be.service;

import com.example.be.entity.SalePayment;
import com.example.be.request.SalePaymentRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SalePaymentService {
    Page<SalePayment> getAll(Integer pageNo);

    SalePayment getOne(Long id);

    SalePayment add(SalePaymentRequest salePaymentRequest);

    SalePayment update(Long id, SalePaymentRequest salePaymentRequest);

    Boolean delete(Long id);
}
