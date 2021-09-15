package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.TicketType;

import java.util.List;

public interface TicketTypeService {

    TicketType findByName(String name);

    List<TicketType> findAllTicketTypes();
}
