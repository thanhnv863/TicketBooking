package com.example.be.repository;

import com.example.be.entity.ComboDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComboDetailRepository extends JpaRepository<ComboDetail, Long> {
}
