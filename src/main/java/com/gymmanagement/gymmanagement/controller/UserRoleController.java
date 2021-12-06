package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.model.UserRole;
import com.gymmanagement.gymmanagement.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @PutMapping("/api/user_role/{id}/update")
    public ResponseEntity<?> updateUserRole(@PathVariable int id, @RequestBody UserRole userRole) {
        return new ResponseEntity<>(userRoleService.saveUserRole(userRole), HttpStatus.OK);
    }

    @PostMapping("/api/user_role/{id}/add")
    public ResponseEntity<?> addUserRole(@RequestBody UserRole userRole) {
        return new ResponseEntity<>(userRoleService.saveUserRole(userRole), HttpStatus.CREATED);
    }

    @GetMapping("/api/user_role/{id_user}/all")
    public ResponseEntity<?> getAllByIdUser(@PathVariable int id_user) {
        return new ResponseEntity<>(userRoleService.findAllByIdUser(id_user), HttpStatus.OK);
    }

}
