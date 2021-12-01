package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> findAllByIdUser(int id);

    void deleteUserRoleByIdUser(int id);

    UserRole saveUserRole(UserRole userRole);
}
