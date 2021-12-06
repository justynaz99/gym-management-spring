package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.Role;

import java.util.List;

public interface RoleService {

    Role findByName(String name);

    List<Role> findAll();
}
