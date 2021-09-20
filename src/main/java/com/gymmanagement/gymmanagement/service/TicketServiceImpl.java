package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.Ticket;
import com.gymmanagement.gymmanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> findTicketsByIdUser(int idUser) {
        return ticketRepository.findTicketsByIdUser(idUser);
    }
}