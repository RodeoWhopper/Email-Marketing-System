package com.service.model;

import com.service.model.category.conc.PurchaseCategory;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;


//We are categorize all targets to make better marketing that is why there is more than one category
@Entity
@Table(name = "users")
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column()
    private String surname;
    private String emailAddress;
    private Date lastPurchaseDate;
    private ArrayList<PurchaseCategory> purchaseMeta;


    public Target(int id, String name, String surname, String emailAddress, Date lastPurchaseDate, ArrayList<PurchaseCategory> purchaseMeta) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.lastPurchaseDate = lastPurchaseDate;
        this.purchaseMeta = purchaseMeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(Date lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }

    public ArrayList<PurchaseCategory> getPurchaseMeta() {
        return purchaseMeta;
    }

    public void setPurchaseMeta(ArrayList<PurchaseCategory> purchaseMeta) {
        this.purchaseMeta = purchaseMeta;
    }
}

