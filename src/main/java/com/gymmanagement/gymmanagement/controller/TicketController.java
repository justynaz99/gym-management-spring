package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.MembershipTicket;
import com.gymmanagement.gymmanagement.service.TicketService;
import com.gymmanagement.gymmanagement.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    TicketTypeService ticketTypeService;


    /**
     *
     * @param id_user of user whose tickets we want to get
     * @return object with info about those tickets
     */
    @GetMapping("/api/ticket/all/{id_user}")
    public ResponseEntity<?> findAllUsersTickets(@PathVariable int id_user) {
        return ResponseEntity.ok(ticketService.findTicketsByIdUser(id_user));
    }

    /**
     *
     * @param ticket to save
     * @return object with info about saved ticket and status code
     */
    @PostMapping("api/ticket/save")
    public ResponseEntity<?> buyTicket(@RequestBody MembershipTicket ticket) {
        return new ResponseEntity<>(ticketService.saveTicket(ticket), HttpStatus.CREATED);
    }

    /**
     *
     * @param ticket to update
     * @return object with info about updated ticket and status code
     */
    @PutMapping("api/ticket/update")
    public ResponseEntity<?> updateTicket(@RequestBody MembershipTicket ticket) {
        return new ResponseEntity<>(ticketService.saveTicket(ticket), HttpStatus.CREATED);
    }

    /**
     *
     * @param id_ticket of ticket to get
     * @return object with info about this ticket
     */
    @GetMapping("/api/ticket/{id_ticket}")
    public ResponseEntity<?> findTicketByIdTicket(@PathVariable int id_ticket) {
        return ResponseEntity.ok(ticketService.findTicketByIdTicket(id_ticket));
    }

    /**
     *
     * @param id_ticket of ticket to delete
     * @return object with id of deleted ticket and status code
     */
    @DeleteMapping("/api/ticket/{id_ticket}/delete")
    public ResponseEntity<?> deleteTicketById(@PathVariable int id_ticket) {
        ticketService.deleteTicketByIdTicket(id_ticket);
        return new ResponseEntity<>(id_ticket, HttpStatus.OK);
    }

}
