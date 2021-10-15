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

    @Column(name = "id_user")
    private int idUser;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_type", referencedColumnName = "id_type", nullable = false)})
    private MembershipTicketType membershipTicketType;




}
