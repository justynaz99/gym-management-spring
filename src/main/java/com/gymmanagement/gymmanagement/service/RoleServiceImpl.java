package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.Role;
import com.gymmanagement.gymmanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     *
     * @param name of role to get
     * @return role with name from param
     */
    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name).orElse(null);
    }

    /**
     *
     * @return all records from Role table
     */
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
