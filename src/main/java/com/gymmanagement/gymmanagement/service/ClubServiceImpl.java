package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.Club;
import com.gymmanagement.gymmanagement.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClubServiceImpl implements ClubService {

    @Autowired
    ClubRepository clubRepository;

    @Override
    public Club findClubById(int id) {
        return clubRepository.findById(id).orElse(null);
    }
}
