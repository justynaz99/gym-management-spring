package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.MembershipTicketType;

import java.util.List;

public interface TicketTypeService {

    MembershipTicketType findByName(String name);

    List<MembershipTicketType> findAllTicketTypes();

    MembershipTicketType saveTicketType(MembershipTicketType ticketType);

    MembershipTicketType findTicketTypeById(int id);

    void deleteTicketTypeById(int id);
}
