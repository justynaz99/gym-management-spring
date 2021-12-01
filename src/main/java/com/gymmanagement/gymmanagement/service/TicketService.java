package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.MembershipTicket;

import java.sql.Date;
import java.util.List;

public interface TicketService {

    List<MembershipTicket> findTicketsByIdUser(int idUser);

    MembershipTicket saveTicket(MembershipTicket ticket);

    void deleteTicketByExpirationDate(Date expirationDate);

    MembershipTicket findTicketByIdTicket(int id);

    void deleteTicketByIdTicket(int id);

}
