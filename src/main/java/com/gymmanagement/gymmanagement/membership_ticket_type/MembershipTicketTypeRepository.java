package com.gymmanagement.gymmanagement.membership_ticket_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipTicketTypeRepository extends JpaRepository<MembershipTicketTypeEntity, Integer> {



}
