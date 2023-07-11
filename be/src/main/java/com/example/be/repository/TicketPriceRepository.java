package com.example.be.repository;

import com.example.be.entity.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPriceRepository extends JpaRepository<TicketPrice, Long> {
    TicketPrice getTicketPriceByChairType_IdAndTypeTicket_Id(Long chairTypeId, Long typeTicketId);
}
