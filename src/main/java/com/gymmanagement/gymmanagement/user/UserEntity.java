package com.gymmanagement.gymmanagement.user;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user", schema = "gym_management")
public class UserEntity {
    private int idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;
    private Integer dateAdded;
    private Integer whoAdded;
    private Integer dateModification;
    private Integer whoModificated;

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "date_added")
    public Integer getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Integer dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Basic
    @Column(name = "who_added")
    public Integer getWhoAdded() {
        return whoAdded;
    }

    public void setWhoAdded(Integer whoAdded) {
        this.whoAdded = whoAdded;
    }

    @Basic
    @Column(name = "date_modification")
    public Integer getDateModification() {
        return dateModification;
    }

    public void setDateModification(Integer dateModification) {
        this.dateModification = dateModification;
    }

    @Basic
    @Column(name = "who_modificated")
    public Integer getWhoModificated() {
        return whoModificated;
    }

    public void setWhoModificated(Integer whoModificated) {
        this.whoModificated = whoModificated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (idUser != that.idUser) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (dateAdded != null ? !dateAdded.equals(that.dateAdded) : that.dateAdded != null) return false;
        if (whoAdded != null ? !whoAdded.equals(that.whoAdded) : that.whoAdded != null) return false;
        if (dateModification != null ? !dateModification.equals(that.dateModification) : that.dateModification != null)
            return false;
        if (whoModificated != null ? !whoModificated.equals(that.whoModificated) : that.whoModificated != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        result = 31 * result + (whoAdded != null ? whoAdded.hashCode() : 0);
        result = 31 * result + (dateModification != null ? dateModification.hashCode() : 0);
        result = 31 * result + (whoModificated != null ? whoModificated.hashCode() : 0);
        return result;
    }
}
