package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    List<UserRole> findAllByIdUser(int id);

    void deleteUserRoleByIdUser(int id);




}
