package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notification")
public class Notification
{
    public Notification() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column
    private Date dataWyslania;
    @Column(length=150)
    public String tresc;
    @Column(length=30)
    private String nazwaNadawcy;
    @Column(length=30)
    private String nazwaOdbiorcy;

    public Notification(String tresc, String nazwaNadawcy, String nazwaOdbiorcy) {
        this.dataWyslania =new Date();
        this.tresc = tresc;
        this.nazwaNadawcy = nazwaNadawcy;
        this.nazwaOdbiorcy = nazwaOdbiorcy;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
