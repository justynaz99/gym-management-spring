package com.gymmanagement.gymmanagement.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ClubPK implements Serializable {
    private int idClub;
    private int idNetwork;

    @Column(name = "id_club")
    @Id
    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    @Column(name = "id_network")
    @Id
    public int getIdNetwork() {
        return idNetwork;
    }

    public void setIdNetwork(int idNetwork) {
        this.idNetwork = idNetwork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClubPK that = (ClubPK) o;

        if (idClub != that.idClub) return false;
        if (idNetwork != that.idNetwork) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClub;
        result = 31 * result + idNetwork;
        return result;
    }
}
