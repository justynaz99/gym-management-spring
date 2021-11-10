package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.MembershipTicket;
import com.gymmanagement.gymmanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<MembershipTicket> findTicketsByIdUser(int idUser) {
        return ticketRepository.findTicketsByIdUser(idUser);
    }

    @Override
    public MembershipTicket saveTicket(MembershipTicket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicketByExpirationDate(Date expirationDate) {
        ticketRepository.deleteMembershipTicketByExpirationDateEquals(expirationDate);
    }
}
