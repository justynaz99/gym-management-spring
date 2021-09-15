package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.TicketType;
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
    public TicketType findByName(String name) {
        return ticketTypeRepository.findByName(name).orElse(null);
    }

    @Override
    public List<TicketType> findAllTicketTypes() {
        return ticketTypeRepository.findAll();
    }
}
