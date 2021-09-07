package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.Club;
import com.gymmanagement.gymmanagement.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ClubController {

    @Autowired
    ClubRepository clubRepository;

    @GetMapping("/clubs")
    public List<Club> getAllClubsNetworks() {
        return clubRepository.findAll();
    }
}
