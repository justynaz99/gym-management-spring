package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.MembershipTicketType;
import com.gymmanagement.gymmanagement.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TicketTypeController {

    @Autowired
    private TicketTypeService ticketTypeService;

    @GetMapping("/api/ticket-type/all")
    public ResponseEntity<?> findAllTicketTypes() {
        return ResponseEntity.ok(ticketTypeService.findAllTicketTypes());
    }

    @PostMapping("/api/ticket-type/add")
    public ResponseEntity<?> addTicketType(@RequestBody MembershipTicketType ticketType) {
        ticketType.setIdClub(1);
        ticketType.setClubIdNetwork(1);
        return new ResponseEntity<>(ticketTypeService.saveTicketType(ticketType), HttpStatus.CREATED);
    }

    @PutMapping("/api/ticket-type/{id}/edit")
    public ResponseEntity<MembershipTicketType> updateTicketType(@PathVariable int id, @RequestBody MembershipTicketType membershipTicketType) {
        return new ResponseEntity<>(ticketTypeService.saveTicketType(membershipTicketType), HttpStatus.OK);
    }

    @GetMapping("/api/ticket-type/{id}")
    public ResponseEntity<?> findTicketTypeById(@PathVariable int id) {
        return new ResponseEntity<>(ticketTypeService.findTicketTypeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/ticket-type/{id}/delete")
    public ResponseEntity<?> deleteTicketType(@PathVariable int id) {
        ticketTypeService.deleteTicketTypeById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



}
