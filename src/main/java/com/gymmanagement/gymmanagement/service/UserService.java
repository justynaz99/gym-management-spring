package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User findByEmail(String email);

    List<User> findAllUsers();
}
