package com.example.be.repository;

import com.example.be.entity.OrderSnack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderSnackRepository extends JpaRepository<OrderSnack, Long> {
    @Query(value = "SELECT * FROM ticket_booking.order_snack where order_snack.id_order = ?1", nativeQuery = true)
    List<OrderSnack> listOrderSnackByIdOrder(Long id);
}
