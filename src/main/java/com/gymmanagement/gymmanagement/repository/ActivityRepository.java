package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
