package com.gymmanagement.gymmanagement.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ActivityPK implements Serializable {
    private int idActivity;
    private int idClub;
    private int clubIdNetwork;

    @Column(name = "id_activity")
    @Id
    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    @Column(name = "id_club")
    @Id
    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    @Column(name = "club_id_network")
    @Id
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

        ActivityPK that = (ActivityPK) o;

        if (idActivity != that.idActivity) return false;
        if (idClub != that.idClub) return false;
        if (clubIdNetwork != that.clubIdNetwork) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idActivity;
        result = 31 * result + idClub;
        result = 31 * result + clubIdNetwork;
        return result;
    }
}
