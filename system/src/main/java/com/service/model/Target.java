package com.service.model;

import com.service.util.enums.PurchaseMeta;

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

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "email")
    private String emailAddress;

    @Temporal(TemporalType.DATE)//This annotation marks for java.sql.Date class
    @Column(name = "lastPurchase")
    private Date lastPurchaseDate;



    @ElementCollection
    @CollectionTable(name = "purchase_meta", joinColumns = @JoinColumn(name = "user_id"))
    //These annotations mark the column as a new table. It creates new table in database called purchase_meta,
    //adds two column that named user_id and purchase_meta, after that adds all list elements to purchase_meta table
    @Enumerated(EnumType.STRING)//It is an enum and should be stored as string
    @Column(name = "purchase_meta")
    private ArrayList<PurchaseMeta> purchaseMeta;


    public Target(int id, String name, String surname, String emailAddress, Date lastPurchaseDate, ArrayList<PurchaseMeta> purchaseMeta) {
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

    public ArrayList<PurchaseMeta> getPurchaseMeta() {
        return purchaseMeta;
    }

    public void setPurchaseMeta(ArrayList<PurchaseMeta> purchaseMeta) {
        this.purchaseMeta = purchaseMeta;
    }
}

