package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.MembershipTicket;
import com.gymmanagement.gymmanagement.service.TicketService;
import com.gymmanagement.gymmanagement.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    TicketTypeService ticketTypeService;

    @GetMapping("/api/ticket/all/{id}")
    public ResponseEntity<?> findAllUsersTickets(@PathVariable int id) {
        return ResponseEntity.ok(ticketService.findTicketsByIdUser(id));
    }

    @PostMapping("api/ticket/save")
    public ResponseEntity<?> buyTicket(@RequestBody MembershipTicket ticket) {
        return new ResponseEntity<>(ticketService.saveTicket(ticket), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/ticket/deleteWhenExpires")
    public ResponseEntity<? > deleteTicketWhenExpires(@PathVariable Date expirationDate) {
        ticketService.deleteTicketByExpirationDate(expirationDate);
        return new ResponseEntity<>(expirationDate, HttpStatus.OK);
    }

    @GetMapping("/api/ticket/{id}")
    public ResponseEntity<?> findTicketByIdTicket(@PathVariable int id) {
        return ResponseEntity.ok(ticketService.findTicketByIdTicket(id));
    }

    @DeleteMapping("/api/ticket/{id}/delete")
    public ResponseEntity<?> deleteTicketById(@PathVariable int id) {
        ticketService.deleteTicketByIdTicket(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
