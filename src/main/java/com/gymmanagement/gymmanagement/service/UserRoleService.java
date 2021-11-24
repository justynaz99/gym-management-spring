package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.UserRole;

public interface UserRoleService {

    UserRole findUserRoleByIdUser(int id);

    void deleteUserRoleByIdUser(int id);

    UserRole saveUserRole(UserRole userRole);
}
