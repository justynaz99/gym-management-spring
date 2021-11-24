package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Integer> {
}
