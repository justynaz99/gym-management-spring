package com.gymmanagement.gymmanagement.membership_ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipTicketRepository extends JpaRepository<MembershipTicketEntity, Integer> {



}
