package com.shah.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
@NamedQuery(name = "Inventory.getByUserName", query = "SELECT i FROM Inventory i where i.name = :name")
@NamedQuery(name = "Inventory.clearAll", query = "DELETE FROM Inventory")
public class Inventory implements Comparable<Inventory>, Serializable {

//Class Variables
    private String name;
    private String sport;
    private String location;
    private int quantity;
    private int price;


    private Date signedUpDate;

    @PrePersist
    void createdAt(){this.signedUpDate = new Date();}

    @PreUpdate
    void updateAt(){this.signedUpDate = new Date();}

//Parameterized constructor
public Inventory(String name,String sport, String location, int quantity, int price)
{
this.name=name;
this.sport=sport;
this.location=location;
this.quantity=quantity;
this.price=price;
}

    @Override
    public int compareTo(Inventory o) {
        return signedUpDate.compareTo(o.signedUpDate);
    }
}
