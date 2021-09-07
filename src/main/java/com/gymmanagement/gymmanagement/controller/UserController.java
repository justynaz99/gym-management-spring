package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.jwt.JwtTokenProvider;
import com.gymmanagement.gymmanagement.model.RoleEnum;
import com.gymmanagement.gymmanagement.model.User;
import com.gymmanagement.gymmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;


    @PostMapping("/user/registration")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(RoleEnum.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/login")
    public ResponseEntity<?> login(Principal principal) {
        if (principal == null)
            return ResponseEntity.ok(principal);
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findByEmail(authenticationToken.getName());
        user.setToken(jwtTokenProvider.generateToken(authenticationToken));


        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
