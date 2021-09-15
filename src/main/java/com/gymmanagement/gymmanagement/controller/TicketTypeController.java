package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TicketTypeController {

    @Autowired
    private TicketTypeService ticketTypeService;

    @GetMapping("/api/ticket-type/all")
    public ResponseEntity<?> findAllTicketTypes() {
        return ResponseEntity.ok(ticketTypeService.findAllTicketTypes());
    }

}
