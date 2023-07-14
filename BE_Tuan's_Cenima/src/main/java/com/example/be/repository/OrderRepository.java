package com.example.be.repository;

import com.example.be.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.staus = 1 or c.staus = 2", nativeQuery = true)
    Page<Order> findOrderStatus(Pageable pageable);

    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.staus = 1 or c.staus = 2 order by c.order_date desc", nativeQuery = true)
    Page<Order> sortDescending(Pageable pageable);

    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.staus = 1 or c.staus = 2 order by c.order_date ", nativeQuery = true)
    Page<Order> sortUp(Pageable pageable);

    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.staus = 1 or c.staus = 2 order by c.time_order ", nativeQuery = true)
    Page<Order> sortUpTime(Pageable pageable);

    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.staus = 1 or c.staus = 2 order by c.time_order desc", nativeQuery = true)
    Page<Order> sortDescendingTime(Pageable pageable);

    @Query(value = "SELECT c.id, c.code, c.id_customer, c.id_employee,c.order_date, c.time_order, c.total_amount, c.total_after_reduction, c.updated_by, c.created_by, c.updated_time, c.created_time, c.staus FROM orders c where c.order_date >= ?1 and c.order_date <= ?2 and c.staus = 1 or c.staus =2", nativeQuery = true)
    Page<Order> searchDate(Date dateFirst, Date dateLast, Pageable pageable);

}
