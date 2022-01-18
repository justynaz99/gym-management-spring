package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.Club;
import com.gymmanagement.gymmanagement.model.MembershipTicket;
import com.gymmanagement.gymmanagement.model.MembershipTicketType;
import com.gymmanagement.gymmanagement.service.ClubService;
import com.gymmanagement.gymmanagement.service.TicketService;
import com.gymmanagement.gymmanagement.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TicketTypeController {

    @Autowired
    private TicketTypeService ticketTypeService;

    @Autowired
    private ClubService clubService;

    @Autowired
    private TicketService ticketService;

    /**
     *
     * @return all records from TicketType table
     */
    @GetMapping("/api/ticket-type/all")
    public ResponseEntity<?> findAllTicketTypes() {
        return ResponseEntity.ok(ticketTypeService.findAllTicketTypes());
    }

    /**
     *
     * @param ticketType to add
     * @return object with info about saved ticket type and status code
     */
    @PostMapping("/api/ticket-type/add")
    public ResponseEntity<?> addTicketType(@RequestBody MembershipTicketType ticketType) {
        Club club = clubService.findClubById(1);
        ticketType.setClub(club); //set the only club in Club table
        return new ResponseEntity<>(ticketTypeService.saveTicketType(ticketType), HttpStatus.CREATED);
    }

    /**
     *
     * @param id of ticket type to edit
     * @param membershipTicketType to edit
     * @return object with info about edited ticket type and status code
     */
    @PutMapping("/api/ticket-type/{id}/edit")
    public ResponseEntity<MembershipTicketType> updateTicketType(@PathVariable int id, @RequestBody MembershipTicketType membershipTicketType) {
        return new ResponseEntity<>(ticketTypeService.saveTicketType(membershipTicketType), HttpStatus.OK);
    }

    /**
     *
     * @param id of ticket type to get
     * @return object with info about this ticket type and status code
     */
    @GetMapping("/api/ticket-type/{id}")
    public ResponseEntity<?> findTicketTypeById(@PathVariable int id) {
        return new ResponseEntity<>(ticketTypeService.findTicketTypeById(id), HttpStatus.OK);
    }

    /**
     *
     * @param id of ticket type to delete
     * @return object with id of deleted ticket type and status code
     */
    @DeleteMapping("/api/ticket-type/{id}/delete")
    public ResponseEntity<?> deleteTicketType(@PathVariable int id) {
        List<MembershipTicket> tickets = ticketService.findAllByMembershipTicketType_IdType(id);
        for (MembershipTicket ticket: tickets) {
            ticket.setMembershipTicketType(null); //need set null in every record from Ticket table containing id of this deleted ticket type
        }
        ticketTypeService.deleteTicketTypeById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



}
