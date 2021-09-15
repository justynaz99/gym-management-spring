package com.gymmanagement.gymmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "activity")
public class Activity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_activity")
    private int idActivity;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "id_club")
    private int idClub;

    @Column(name = "club_id_network")
    private int clubIdNetwork;
}
