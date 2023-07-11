package com.example.be.repository;

import com.example.be.entity.Snacks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackRepository extends JpaRepository<Snacks, Long> {
}
