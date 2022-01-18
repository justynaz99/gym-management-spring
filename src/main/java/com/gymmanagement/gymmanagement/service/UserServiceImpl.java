package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.Role;
import com.gymmanagement.gymmanagement.model.User;
import com.gymmanagement.gymmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     *
     * @param user to save
     * @return saved user object
     */
    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword())); //encodes password
        return userRepository.save(user);
    }

    /**
     *
     * @param username of user to get
     * @return found user or null
     */
    @Override
    public User findUserByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);
    }

    /**
     *
     * @return all records from User table
     */
    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }


    /**
     *
     * @param user to save
     * @return saved user
     */
    public User saveUserOnUpdate(User user){
        return userRepository.save(user);
    }


    /**
     * finds user by token from param
     * @param token
     * @return found user
     */
    @Override
    public User findByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    /**
     *
     * @param user whose password will be update
     * @param newPassword
     */
    @Override
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //need to encode to password to save it in database
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }

    /**
     *
     * @param id of user to get
     * @return found user
     */
    @Override
    public User findUserById(int id) {
        return userRepository.findByIdUser(id);
    }

    /**
     *
     * @param id of user to delete
     */
    @Override
    public void deleteUserByIdUser(int id) {
        userRepository.deleteByIdUser(id);
    }

    /**
     *
     * @param role with we want to find users
     * @return users with this role
     */
    @Override
    public List<User> findAllByRolesIsStartingWith(Role role) {
        return userRepository.findAllByRolesIsStartingWith(role);
    }
}

