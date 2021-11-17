package com.gymmanagement.gymmanagement.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "membership_ticket_type")

public class MembershipTicketType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type")
    private int idType;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private int duration;

    @Column(name = "description")
    private String description;

    @Column(name = "id_club")
    private int idClub;

    @Column(name = "id_network")
    private int idNetwork;

//    @OneToMany(mappedBy = "membershipTicketType")
//    private Collection<MembershipTicket> membershipTickets;



}
