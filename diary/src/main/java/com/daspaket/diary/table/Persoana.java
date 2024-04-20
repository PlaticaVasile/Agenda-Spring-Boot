
package com.daspaket.diary.table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;


@Entity
@Table
public class Persoana
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Username")
    private String nume;
    @Column(name = "Password")
    private String parola;
    Persoana()
    {
        //default constructor
    }
    Persoana(String nume1, String parola1)
    {
        super();
        this.nume = nume1;
        this.parola = parola1;
    }
    public void setNume(String nume1) { this.nume = nume1; }
    public void setParola(String parola1) { this.parola = parola1; }
    public String getNume() { return this.nume; }
    public String getParola() { return this.parola; }
    public String ToString()
    {
        return "Persoana[nume=" + nume + ", parola=" + parola + "]";
    }
}
