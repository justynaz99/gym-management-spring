package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.model.Role;
import com.gymmanagement.gymmanagement.model.User;
import com.gymmanagement.gymmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * method checks if this username already exists in database
     * @param username
     * @return object with username, password and authorities list
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }

        //authorize user according to user role
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role: user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
