package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.MembershipTicketType;
import com.gymmanagement.gymmanagement.repository.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketTypeServiceImpl implements TicketTypeService {

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @Override
    public MembershipTicketType findByName(String name) {
        return ticketTypeRepository.findByName(name).orElse(null);
    }

    @Override
    public List<MembershipTicketType> findAllTicketTypes() {
        return ticketTypeRepository.findAll();
    }

    @Override
    public MembershipTicketType saveTicketType(MembershipTicketType ticketType) {
        return ticketTypeRepository.save(ticketType);
    }

    @Override
    public MembershipTicketType findTicketTypeById(int id) {
        return ticketTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTicketTypeById(int id) {
        ticketTypeRepository.deleteById(id);
    }
}
