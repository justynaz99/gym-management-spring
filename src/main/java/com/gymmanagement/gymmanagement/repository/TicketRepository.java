package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findTicketsByIdUser(int idUser);

}
