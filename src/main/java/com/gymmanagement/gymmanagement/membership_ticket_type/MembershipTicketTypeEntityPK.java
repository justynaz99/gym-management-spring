package com.gymmanagement.gymmanagement.membership_ticket_type;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MembershipTicketTypeEntityPK implements Serializable {
    private int idType;
    private int idClub;
    private int clubIdNetwork;

    @Column(name = "id_type")
    @Id
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
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

        MembershipTicketTypeEntityPK that = (MembershipTicketTypeEntityPK) o;

        if (idType != that.idType) return false;
        if (idClub != that.idClub) return false;
        if (clubIdNetwork != that.clubIdNetwork) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idType;
        result = 31 * result + idClub;
        result = 31 * result + clubIdNetwork;
        return result;
    }
}
