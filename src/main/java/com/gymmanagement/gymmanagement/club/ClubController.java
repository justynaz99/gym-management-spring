package com.gymmanagement.gymmanagement.club;

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
    public List<ClubEntity> getAllClubsNetworks() {
        return clubRepository.findAll();
    }
}
