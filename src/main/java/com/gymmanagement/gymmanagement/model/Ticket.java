package com.gymmanagement.gymmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "membership_ticket")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_ticket")
    private int idTicket;

    @Column(name = "activation_date")
    private Date activationDate;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "id_type")
    private int idType;

    @Column(name = "id_club")
    private int idClub;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "id_network")
    private int idNetwork;


}
