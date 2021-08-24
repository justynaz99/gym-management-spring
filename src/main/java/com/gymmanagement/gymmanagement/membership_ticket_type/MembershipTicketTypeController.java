package com.gymmanagement.gymmanagement.membership_ticket_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MembershipTicketTypeController {

    @Autowired
    MembershipTicketTypeRepository membershipTicketTypeRepository;

    @GetMapping("/membership-ticket-types")
    public List<MembershipTicketTypeEntity> findAll() {
        return membershipTicketTypeRepository.findAll();
    }

}
