package com.gymmanagement.gymmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "membership_ticket")
public class MembershipTicket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private int idTicket;

    @Column(name = "ticket_name")
    private String ticketName;

    @Column(name = "activation_date")
    private Date activationDate;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "id_club")
    private int idClub;

    @Column(name = "id_network")
    private int idNetwork;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_type", referencedColumnName = "id_type")})
    private MembershipTicketType membershipTicketType;





}
