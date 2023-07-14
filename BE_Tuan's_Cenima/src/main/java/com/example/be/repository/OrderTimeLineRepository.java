package com.example.be.repository;

import com.example.be.entity.OrderTimeLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTimeLineRepository extends JpaRepository<OrderTimeLine, Long> {
    @Query(value = "SELECT * FROM ticket_booking.order_time_line order by order_time_line.created_time", nativeQuery = true)
    List<OrderTimeLine> getAllTime();
}
