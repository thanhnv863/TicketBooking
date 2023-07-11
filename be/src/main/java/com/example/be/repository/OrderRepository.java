package com.example.be.repository;

import com.example.be.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.staus = 1 or c.staus = 2", nativeQuery = true)
    List<Order> findOrderStatus();

    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.staus = 1 or c.staus = 2 order by c.order_date desc", nativeQuery = true)
    List<Order> sortDescending();

    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.staus = 1 or c.staus = 2 order by c.order_date ", nativeQuery = true)
    List<Order> sortUp();

    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.staus = 1 or c.staus = 2 order by c.time_order ", nativeQuery = true)
    List<Order> sortUpTime();

    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.staus = 1 or c.staus = 2 order by c.time_order desc", nativeQuery = true)
    List<Order> sortDescendingTime();
}
