package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.jwt.JwtTokenProvider;
import com.gymmanagement.gymmanagement.model.Role;
import com.gymmanagement.gymmanagement.model.User;
import com.gymmanagement.gymmanagement.model.UserRole;
import com.gymmanagement.gymmanagement.service.EnrollmentService;
import com.gymmanagement.gymmanagement.service.RoleService;
import com.gymmanagement.gymmanagement.service.UserRoleService;
import com.gymmanagement.gymmanagement.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    EnrollmentService enrollmentService;

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * method to register new user
     * @param user to save in User table
     * @return object with info about saved user and status code
     */
    @PostMapping("/api/user-auth/registration")
    public ResponseEntity<?> register(@RequestBody User user) {

        if (userService.findUserByUsername(user.getUsername()) != null) { //if user with this username already exists in table User
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        //need to save first and then update to be able to get autogenerated id and set it in whoAdded
        User savedUser = userService.saveUser(user);

        savedUser.setDateAdded(new Date());
        //set that this user added himself
        savedUser.setWhoAdded(savedUser.getIdUser());

        userService.saveUserOnUpdate(savedUser);

        //create record in UserRole table for this user
        Role role = roleService.findByName("USER");
        UserRole userRole = new UserRole();
        userRole.setIdUser(savedUser.getIdUser());
        userRole.setIdRole(role.getIdRole());
        userRoleService.saveUserRole(userRole);


        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     *
     * @param id of user to edit
     * @param user to edit
     * @return object with info about edited user and status code
     */
    @PutMapping("/api/user/{id}/edit")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUserOnUpdate(user), HttpStatus.OK);
    }

    /**
     *
     * @param id of user whose password is edited
     * @param user whose password is edited
     * @return object with info about user whose password was edited and status code
     */
    @PutMapping("/api/user/{id}/edit-password")
    public ResponseEntity<User> updatePassword(@PathVariable int id, @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }


    /**
     *
     * @param principal
     * @return
     */
    @GetMapping("/api/user-auth/login")
    public ResponseEntity<?> login(Principal principal) {
        if (principal == null) {
            //This should be ok http status because this will be used for logout path.
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findUserByUsername(authenticationToken.getName());
        user.setToken(jwtTokenProvider.generateToken(authenticationToken));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @GetMapping("/api/user/{username}")
//    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
//        return new ResponseEntity<User>(userService.findUserByUsername(username), HttpStatus.OK);
//    }

    /**
     *
     * @param id of user to get
     * @return object with info about this user and status code
     */
    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> findUserByIdUser(@PathVariable int id) {
        return new ResponseEntity<User>(userService.findUserById(id), HttpStatus.OK);
    }

    /**
     *
     * @param token of user to get
     * @return object with info about this user and status code
     */
    @GetMapping("/api/user/find_by_token/{token}")
    public ResponseEntity<User> findUserByToken(@PathVariable String token) {
        return new ResponseEntity<User>(userService.findByResetPasswordToken(token), HttpStatus.OK);
    }

    /**
     *
     * @return object with info about got users
     */
    @GetMapping("/api/user/all")
    public ResponseEntity<?> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    /**
     *
     * @param id of user to delete
     * @return object with id of deleted user and status code
     */
    @DeleteMapping("/api/user/{id}/delete")
    ResponseEntity<?> deleteUserById(@PathVariable int id) {
        userRoleService.deleteUserRoleByIdUser(id);
        User user = userService.findUserById(id);
        enrollmentService.deleteAllByUser(user);
        userService.deleteUserByIdUser(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    /**
     *
     * @param id of user whose UserRole we want to get
     * @return object with info about got UserRole and status code
     */
    @GetMapping("/api/user/{id}/roles")
    ResponseEntity<?> findUserRolesByIdUser(@PathVariable int id) {
        return ResponseEntity.ok(userRoleService.findAllByIdUser(id));
    }

    /**
     * method checks if user with this token exists in database
     * @param token
     * @return true or false, if user with this token exists
     */
    @GetMapping("/api/user/token_validation/{token}")
    boolean isResetTokenValid(@PathVariable String token) {
        User user = userService.findByResetPasswordToken(token);
        return user != null;
    }


    /**
     * method generates token and save it in User table
     * then it creates and send an email with this token to user (username is email) from param
     * @param username of user for whom token is generated and email is sent
     * @return status code
     */
    @GetMapping("/api/user/generate_reset_token/{username}")
    ResponseEntity<?> generateResetToken(@PathVariable String username) {
        User user = userService.findUserByUsername(username);
        if (user == null) return ResponseEntity.badRequest().build();
        String token = RandomString.make(30);
        user.setResetPasswordToken(token);
        userService.saveUserOnUpdate(user);
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            String htmlMessage = "<h3>Resetowanie hasła</h3>" +
                    "<br/> Kliknij link: http://localhost:4200/reset-password/" + token;
            helper.setText(htmlMessage, true);
            helper.setTo(username);
            helper.setSubject("Reset hasła");
            helper.setFrom("szks.pl");
            javaMailSender.send(mimeMessage);
            System.out.println("Sent");
            return ResponseEntity.ok().build();
        } catch (MessagingException e) {
            System.out.println("Error");
            return ResponseEntity.badRequest().build();
        }

    }

    /**
     *
     * @param role_name of role which users we want to get
     * @return object with info about all users with this role
     */
    @GetMapping("/api/user/{role_name}/all_by_role")
    public ResponseEntity<?> findAllByRole(@PathVariable String role_name) {
        Role role = roleService.findByName(role_name);
        System.out.println("Rola: " + role);
        return ResponseEntity.ok(userService.findAllByRolesIsStartingWith(role));
    }



}
