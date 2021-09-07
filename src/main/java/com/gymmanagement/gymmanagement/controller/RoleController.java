package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.Role;
import com.gymmanagement.gymmanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<Role> getAllUsers() {
        return roleRepository.findAll();
    }
}
