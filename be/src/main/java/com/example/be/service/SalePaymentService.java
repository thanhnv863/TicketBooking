package com.example.be.service;

import com.example.be.entity.SalePayment;
import com.example.be.request.SalePaymentRequest;

import java.util.List;

public interface SalePaymentService {
    List<SalePayment> getAll();

    SalePayment getOne(Long id);

    SalePayment add(SalePaymentRequest salePaymentRequest);

    SalePayment update(Long id, SalePaymentRequest salePaymentRequest);

    Boolean delete(Long id);
}
