package com.gymmanagement.gymmanagement.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TicketPK implements Serializable {
    private int idTicket;
    private int idType;
    private int idClub;
    private int idUser;
    private int idNetwork;

    @Column(name = "id_ticket")
    @Id
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

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

    @Column(name = "id_user")
    @Id
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

        TicketPK that = (TicketPK) o;

        if (idTicket != that.idTicket) return false;
        if (idType != that.idType) return false;
        if (idClub != that.idClub) return false;
        if (idUser != that.idUser) return false;
        if (idNetwork != that.idNetwork) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTicket;
        result = 31 * result + idType;
        result = 31 * result + idClub;
        result = 31 * result + idUser;
        result = 31 * result + idNetwork;
        return result;
    }
}
