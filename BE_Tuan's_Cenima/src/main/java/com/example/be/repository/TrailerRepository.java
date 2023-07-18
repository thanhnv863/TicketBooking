package com.example.be.repository;

import com.example.be.entity.Directors;
import com.example.be.entity.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailerRepository extends JpaRepository<Trailer, Long> {
}
