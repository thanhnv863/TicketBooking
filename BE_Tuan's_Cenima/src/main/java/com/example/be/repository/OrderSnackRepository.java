package com.example.be.repository;

import com.example.be.entity.OrderSnack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSnackRepository extends JpaRepository<OrderSnack, Long> {
}
