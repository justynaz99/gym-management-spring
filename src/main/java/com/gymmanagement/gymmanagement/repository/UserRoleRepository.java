package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    UserRole findUserRoleByIdUser(int id);

    void deleteUserRoleByIdUser(int id);
}
