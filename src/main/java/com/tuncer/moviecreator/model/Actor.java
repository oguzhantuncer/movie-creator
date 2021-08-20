package com.tuncer.moviecreator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Date birthDate;

    @ManyToMany(mappedBy = "actorsInMovie")
    @JsonIgnore
    private Set<Movie> movies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFullName(){
        return this.name + " " + this.surname;
    }


    @Override
    public int hashCode() {
        return Objects.hash(birthDate, id, name, surname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Actor other = (Actor) obj;
        return Objects.equals(birthDate, other.birthDate) && Objects.equals(id, other.id)
                && Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
    }

    @Override
    public String toString() {
        return "Actor [id=" + id + ", name=" + name + ", surname=" + surname + ", birthDate=" + birthDate + "]";
    }


}
