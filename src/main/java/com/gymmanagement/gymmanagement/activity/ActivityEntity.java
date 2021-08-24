package com.gymmanagement.gymmanagement.activity;

import javax.persistence.*;

@Entity
@Table(name = "activity", schema = "gym_management")
@IdClass(ActivityEntityPK.class)
public class ActivityEntity {

    private int idActivity;
    private String name;
    private String description;
    private int idClub;
    private int clubIdNetwork;

    @Id
    @GeneratedValue
    @Column(name = "id_activity")
    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "id_club")
    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    @Id
    @Column(name = "club_id_network")
    public int getClubIdNetwork() {
        return clubIdNetwork;
    }

    public void setClubIdNetwork(int clubIdNetwork) {
        this.clubIdNetwork = clubIdNetwork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityEntity that = (ActivityEntity) o;

        if (idActivity != that.idActivity) return false;
        if (idClub != that.idClub) return false;
        if (clubIdNetwork != that.clubIdNetwork) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idActivity;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + idClub;
        result = 31 * result + clubIdNetwork;
        return result;
    }
}
