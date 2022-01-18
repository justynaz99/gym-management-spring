package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.UserRole;
import com.gymmanagement.gymmanagement.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;


    @Override
    public List<UserRole> findAllByIdUser(int id) {
        return userRoleRepository.findAllByIdUser(id);
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
