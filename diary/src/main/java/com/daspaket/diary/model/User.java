package com.daspaket.diary.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@CrossOrigin("http://localhost:3001") //or 3000
@Table(name = "User") //imi asigura ca nu-mi creeaza un alt tabel + sa scriem ca faca doar update in app.prop
public class User
{
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @Column(name = "Username")
    private String Username;
    @Column(name = "Password")
    private String Password;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Type")
    private String Type;

    public User()
    {
        //default constructor
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID1) {
        this.ID = ID1;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username1) {
        Username = username1;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password1) {
        Password = password1;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email1) {
        Email = email1;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type1) {
        Type = type1;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}
