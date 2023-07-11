package com.example.be.repository;

import com.example.be.entity.SalePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalePaymentRepository extends JpaRepository<SalePayment, Long> {
}
