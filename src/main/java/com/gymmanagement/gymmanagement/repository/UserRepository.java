package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.model.Role;
import com.gymmanagement.gymmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    User findByResetPasswordToken(String token);

    User findByIdUser(int id);

    void deleteByIdUser(int id);

    List<User> findAllByRolesIsStartingWith(Role role);


}
