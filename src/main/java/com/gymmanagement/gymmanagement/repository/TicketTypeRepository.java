package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.MembershipTicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketTypeRepository extends JpaRepository<MembershipTicketType, Integer> {

    Optional<MembershipTicketType> findByName(String name);

}
