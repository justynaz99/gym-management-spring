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

//    @ManyToOne
//    @JoinColumns({@JoinColumn(name = "id_type", referencedColumnName = "id_type", nullable = false),
//            @JoinColumn(name = "id_club", referencedColumnName = "id_club", nullable = false),
//            @JoinColumn(name = "id_network", referencedColumnName = "club_id_network", nullable = false)})
//    private MembershipTicketType membershipTicketType;
//
//    @ManyToOne
//    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
//    private User userByIdUser;


}
