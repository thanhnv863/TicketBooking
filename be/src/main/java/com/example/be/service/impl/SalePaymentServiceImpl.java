package com.example.be.service.impl;

import com.example.be.entity.SalePayment;
import com.example.be.repository.SalePaymentRepository;
import com.example.be.request.SalePaymentRequest;
import com.example.be.service.SalePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalePaymentServiceImpl implements SalePaymentService {
    @Autowired
    private SalePaymentRepository salePaymentRepository;

    @Override
    public List<SalePayment> getAll() {
        return salePaymentRepository.findAll();
    }

    @Override
    public SalePayment getOne(Long id) {
        return salePaymentRepository.findById(id).get();
    }

    @Override
    public SalePayment add(SalePaymentRequest salePaymentRequest) {
        Date date = new Date();
        SalePayment salePayment = SalePayment.builder()
                .paymentTime(date)
                .description(salePaymentRequest.getDescription())
                .amount(salePaymentRequest.getAmount())
                .order(salePaymentRequest.getOrder())
                .build();
        return salePaymentRepository.save(salePayment);
    }

    @Override
    public SalePayment update(Long id, SalePaymentRequest salePaymentRequest) {
        Date date = new Date();
        SalePayment salePayment = salePaymentRepository.findById(id).get();
        salePayment.setId(id);
        salePayment.setAmount(salePaymentRequest.getAmount());
        salePayment.setDescription(salePaymentRequest.getDescription());
        return salePaymentRepository.save(salePayment);
    }

    @Override
    public Boolean delete(Long id) {
        SalePayment salePayment = salePaymentRepository.findById(id).get();
        if (salePayment == null) {
            return false;
        } else {
            salePaymentRepository.deleteById(id);
            return true;
        }
    }
}
