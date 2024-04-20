package com.daspaket.diary.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
//@CrossOrigin("http://localhost:3001") //or 3000
@Table(name = "SecurityQuestion")
public class SecurityQuestion
{
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @Column(name = "Question")
    private String Question;
    @Column(name = "Answer")
    private String Answer;
    @Column(name = "ID_User")
    private int ID_User;

    public SecurityQuestion()
    {
        //default constructor
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID1) {
        this.ID = ID1;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question1) {
        Question = question1;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer1) {
        Answer = answer1;
    }

    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_User1) {
        this.ID_User = ID_User1;
    }

    @Override
    public String toString() {
        return "SecurityQuestion{" +
                "ID=" + ID +
                ", Question='" + Question + '\'' +
                ", Answer='" + Answer + '\'' +
                ", ID_User=" + ID_User +
                '}';
    }
}
