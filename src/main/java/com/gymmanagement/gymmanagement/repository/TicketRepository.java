package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.MembershipTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<MembershipTicket, Integer> {

    List<MembershipTicket> findTicketsByIdUser(int idUser);

}
