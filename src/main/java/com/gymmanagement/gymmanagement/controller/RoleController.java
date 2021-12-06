package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/api/role/all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }
}
