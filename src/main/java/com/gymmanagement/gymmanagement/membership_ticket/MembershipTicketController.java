package com.gymmanagement.gymmanagement.membership_ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MembershipTicketController {

    @Autowired
    MembershipTicketRepository membershipTicketRepository;

    @GetMapping("/membership-tickets")
    public List<MembershipTicketEntity> findAll() {
        return membershipTicketRepository.findAll();
    }

}
