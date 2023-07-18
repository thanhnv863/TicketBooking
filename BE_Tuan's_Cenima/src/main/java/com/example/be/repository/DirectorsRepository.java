package com.example.be.repository;

import com.example.be.entity.Directors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorsRepository extends JpaRepository<Directors, Long> {
}
