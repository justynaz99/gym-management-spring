package com.gymmanagement.gymmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Column(name = "date_added")
    private Date dateAdded;

    @Column(name = "who_added")
    private int whoAdded;

    @Column(name = "date_modification")
    private Date dateModification;

    @Column(name = "who_modificated")
    private int whoModificated;

    @Transient
    private String token;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;
}