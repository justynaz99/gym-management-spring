package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> findTicketsByIdUser(int idUser);
}
