package com.gymmanagement.gymmanagement.clubs_network;

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
    public List<ClubsNetworkEntity> getAllClubsNetworks() {
        return clubsNetworkRepository.findAll();
    }
}
