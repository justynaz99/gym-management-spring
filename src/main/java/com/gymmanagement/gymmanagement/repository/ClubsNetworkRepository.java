package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.ClubsNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubsNetworkRepository extends JpaRepository<ClubsNetwork, Integer> {


}
