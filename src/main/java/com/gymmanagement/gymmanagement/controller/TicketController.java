package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.Ticket;
import com.gymmanagement.gymmanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/membership-tickets")
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

}
