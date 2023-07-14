package com.example.be.repository;

import com.example.be.entity.Snacks;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SnackRepository extends JpaRepository<Snacks, Long> {
    List<Snacks> findByStatus(Integer status, Sort sort);
}
