package com.gymmanagement.gymmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "activity_position_in_schedule")
public class ActivityPositionInSchedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_position")
    private int idPosition;

    @Column(name = "date")
    private Date date;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "finish_time")
    private Timestamp finishTime;

    @Column(name = "coach")
    private String coach;

//    @Column(name = "id_club")
//    private int idClub;
//
//    @Column(name = "id_network")
//    private int idNetwork;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_activity", referencedColumnName = "id_activity", nullable = false),
            @JoinColumn(name = "id_club", referencedColumnName = "id_club", nullable = false),
            @JoinColumn(name = "id_network", referencedColumnName = "id_network", nullable = false)})
    private Activity activity;


}

