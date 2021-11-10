package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User saveUserOnUpdate(User user);

    User findUserByUsername(String username);

    List<User> findAllUsers();

    void updateResetPasswordToken(String token, String username);

    User findByResetPasswordToken(String token);

    void updatePassword(User user, String newPassword);

    User findUserById(int id);
}
