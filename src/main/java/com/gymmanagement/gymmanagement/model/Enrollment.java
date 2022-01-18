package com.gymmanagement.gymmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "enrollment")
public class Enrollment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enrollment")
    private int idEnrollment;

    @Column(name = "id_activity")
    private Integer idActivity;

    @Column(name = "id_club")
    private Integer idClub;

    @Column(name = "id_network")
    private Integer idNetwork;

//    @Column(name = "id_user")
//    private Integer idUser;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)})
    private User user;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_position", referencedColumnName = "id_position", nullable = false)})
    private ActivityPositionInSchedule position;
}
