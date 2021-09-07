package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {


}
