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

    /**
     * method gets all tickets of user from param
     * @param idUser
     * @return all tickets of user from param
     */
    @Override
    public List<MembershipTicket> findTicketsByIdUser(int idUser) {
        return ticketRepository.findTicketsByIdUserOrderByExpirationDateDesc(idUser);
    }

    /**
     *
     * @param ticket to save
     * @return saved ticket
     */
    @Override
    public MembershipTicket saveTicket(MembershipTicket ticket) {
        return ticketRepository.save(ticket);
    }


    @Override
    public void deleteTicketByExpirationDate(Date expirationDate) {
        ticketRepository.deleteMembershipTicketByExpirationDateEquals(expirationDate);
    }

    /**
     *
     * @param idTicket of ticket to get
     * @return ticket with id from param
     */
    @Override
    public MembershipTicket findTicketByIdTicket(int idTicket) {
        return ticketRepository.findByIdTicket(idTicket);
    }

    /**
     *
     * @param idTicket of ticket to delete
     */
    @Override
    public void deleteTicketByIdTicket(int idTicket) {
        ticketRepository.deleteMembershipTicketByIdTicket(idTicket);
    }

    /**
     *
     * @param idType of type of tickets to get
     * @return all tickets of type from param
     */
    @Override
    public List<MembershipTicket> findAllByMembershipTicketType_IdType(int idType) {
        return ticketRepository.findAllByMembershipTicketType_IdType(idType);
    }
}
