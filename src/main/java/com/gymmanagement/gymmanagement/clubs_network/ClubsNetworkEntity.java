package com.gymmanagement.gymmanagement.clubs_network;

import javax.persistence.*;

@Entity
@Table(name = "clubs_network", schema = "gym_management")
public class ClubsNetworkEntity {
    private int idNetwork;
    private String name;
    private String owner;

    @Id
    @GeneratedValue
    @Column(name = "id_network")
    public int getIdNetwork() {
        return idNetwork;
    }

    public void setIdNetwork(int idNetwork) {
        this.idNetwork = idNetwork;
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
    @Column(name = "owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClubsNetworkEntity that = (ClubsNetworkEntity) o;

        if (idNetwork != that.idNetwork) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNetwork;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
