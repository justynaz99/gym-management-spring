package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.ClubsNetwork;
import com.gymmanagement.gymmanagement.repository.ClubsNetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ClubsNetworkController {

    @Autowired
    ClubsNetworkRepository clubsNetworkRepository;

    @GetMapping("/clubs-networks")
    public List<ClubsNetwork> getAllClubsNetworks() {
        return clubsNetworkRepository.findAll();
    }
}
