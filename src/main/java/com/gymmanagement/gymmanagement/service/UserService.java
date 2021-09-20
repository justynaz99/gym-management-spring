package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User saveUserOnUpdate(User user);

    User findByUsername(String username);

    List<User> findAllUsers();
}
