package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.Role;

public interface RoleService {

    Role findByName(String name);
}
