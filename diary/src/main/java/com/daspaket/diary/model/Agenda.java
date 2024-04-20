package com.daspaket.diary.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
//CORS
@Table(name = "Agenda")
public class Agenda
{
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @Column(name = "Notes")
    private String Notes;
    @Column(name = "Date")
    private Date Date;
    @Column(name = "ID_User")
    private int ID_User;

    public Agenda()
    {
        //default constructor
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID1) {
        this.ID = ID1;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes1) {
        Notes = notes1;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date1) {
        Date = date1;
    }

    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_User1) {
        this.ID_User = ID_User1;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "ID=" + ID +
                ", Notes='" + Notes + '\'' +
                ", Date=" + Date +
                ", ID_User=" + ID_User +
                '}';
    }
}
