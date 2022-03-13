package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     *
     * @return object with info about all records from Role table
     */
    @GetMapping("/api/role/all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/role/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok(roleService.findByName(name));
    }
}
