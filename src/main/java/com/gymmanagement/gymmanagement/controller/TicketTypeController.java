package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.TicketType;
import com.gymmanagement.gymmanagement.repository.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TicketTypeController {

    @Autowired
    TicketTypeRepository ticketTypeRepository;

    @GetMapping("/ticket-types")
    public List<TicketType> getAllTicketTypes() {
        return ticketTypeRepository.findAll();
    }

}
