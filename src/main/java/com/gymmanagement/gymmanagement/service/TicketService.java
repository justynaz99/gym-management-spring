package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.MembershipTicket;

import java.util.List;

public interface TicketService {

    List<MembershipTicket> findTicketsByIdUser(int idUser);
}
