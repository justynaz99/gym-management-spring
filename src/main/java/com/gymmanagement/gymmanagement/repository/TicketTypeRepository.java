package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Integer> {



}
