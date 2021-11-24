package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.UserRole;
import com.gymmanagement.gymmanagement.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole findUserRoleByIdUser(int id) {
        return userRoleRepository.findUserRoleByIdUser(id);
    }

    @Override
    public void deleteUserRoleByIdUser(int id) {
        userRoleRepository.deleteUserRoleByIdUser(id);
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }
}
