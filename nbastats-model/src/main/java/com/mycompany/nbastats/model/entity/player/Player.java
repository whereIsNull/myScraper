/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.nbastats.model.entity.player;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author cristobal
 */
@Entity
public class Player implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Long birthDateInMillis;
    private Long DeathDateInMillis;

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

    public Long getBirthDateInMillis() {
        return birthDateInMillis;
    }

    public void setBirthDateInMillis(Long birthDateInMillis) {
        this.birthDateInMillis = birthDateInMillis;
    }

    public Long getDeathDateInMillis() {
        return DeathDateInMillis;
    }

    public void setDeathDateInMillis(Long DeathDateInMillis) {
        this.DeathDateInMillis = DeathDateInMillis;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.surname);
        hash = 83 * hash + Objects.hashCode(this.birthDateInMillis);
        hash = 83 * hash + Objects.hashCode(this.DeathDateInMillis);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.birthDateInMillis, other.birthDateInMillis)) {
            return false;
        }
        if (!Objects.equals(this.DeathDateInMillis, other.DeathDateInMillis)) {
            return false;
        }
        return true;
    }

    
    
}
