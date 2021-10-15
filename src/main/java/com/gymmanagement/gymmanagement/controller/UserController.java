package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.jwt.JwtTokenProvider;
import com.gymmanagement.gymmanagement.model.User;
import com.gymmanagement.gymmanagement.service.RoleService;
import com.gymmanagement.gymmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user){
        if(userService.findUserByUsername(user.getUsername()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        User savedUser = userService.saveUser(user);

        savedUser.setDateAdded(new Date());
        savedUser.setWhoAdded(savedUser.getIdUser());

        userService.saveUserOnUpdate(savedUser);

//        Role role = roleService.findByName("USER");
//
//        System.out.println("Znaleziona rola: " + role.getName());


//        UserRole role = new UserRole();
//        role.setUser(savedUser);
//        role.setRole(roleService.findByName("USER"));
//        role.setIdUserRole(1);
//        System.out.println("Rola: " + role);
//        userRoleService.saveUserRole(role);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/api/user/{id}/edit")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUserOnUpdate(user), HttpStatus.OK);
    }

    @PutMapping("/api/user/{id}/edit-password")
    public ResponseEntity<User> updatePassword(@PathVariable int id, @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }


    @GetMapping("/api/user/login")
    public ResponseEntity<?> login(Principal principal){
        if(principal == null){
            //This should be ok http status because this will be used for logout path.
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findUserByUsername(authenticationToken.getName());
        user.setToken(jwtTokenProvider.generateToken(authenticationToken));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/api/user/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        return new ResponseEntity<User>(userService.findUserByUsername(username), HttpStatus.OK);
    }
}
