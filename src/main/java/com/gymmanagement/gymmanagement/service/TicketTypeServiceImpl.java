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

    /**
     *
     * @param name of ticket type to get
     * @return ticket type with name from param
     */
    @Override
    public MembershipTicketType findByName(String name) {
        return ticketTypeRepository.findByName(name).orElse(null);
    }

    /**
     *
     * @return all records from MembershipTicketType table
     */
    @Override
    public List<MembershipTicketType> findAllTicketTypes() {
        return ticketTypeRepository.findAll();
    }

    /**
     *
     * @param ticketType to save
     * @return saved ticket type
     */
    @Override
    public MembershipTicketType saveTicketType(MembershipTicketType ticketType) {
        return ticketTypeRepository.save(ticketType);
    }

    /**
     *
     * @param id of ticket type to get
     * @return ticket type with id from param or null
     */
    @Override
    public MembershipTicketType findTicketTypeById(int id) {
        return ticketTypeRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param id of ticket type to delete
     */
    @Override
    public void deleteTicketTypeById(int id) {
        ticketTypeRepository.deleteById(id);
    }
}
