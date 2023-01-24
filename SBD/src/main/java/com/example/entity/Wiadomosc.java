package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
@Entity
@Table(name = "wiadomosc")
public class Wiadomosc
{
    public Wiadomosc() {
        this.dataWyslania =new Date();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column
    private Date dataWyslania;
    @Column(length=150)
    private String tresc;
    @Column(length=30)
    private String nazwaNadawcy;
    @Column(length=30)
    private String nazwaOdbiorcy;

    public Wiadomosc(Integer id, Date dataWyslania, String tresc, String nazwaNadawcy, String nazwaOdbiorcy) {
        this.id = id;
        this.dataWyslania = dataWyslania;
        this.tresc = tresc;
        this.nazwaNadawcy = nazwaNadawcy;
        this.nazwaOdbiorcy = nazwaOdbiorcy;
    }
    public Wiadomosc(Integer id,  String tresc, String nazwaNadawcy, String nazwaOdbiorcy) {

        this.id = id;
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

    public Date getDataWyslania() {
        return dataWyslania;
    }

    public void setDataWyslania(Date dataWyslania) {
        this.dataWyslania = dataWyslania;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public String getNazwaNadawcy() {
        return nazwaNadawcy;
    }

    public void setNazwaNadawcy(String nazwaNadawcy) {
        this.nazwaNadawcy = nazwaNadawcy;
    }

    public String getNazwaOdbiorcy() {
        return nazwaOdbiorcy;
    }

    public void setNazwaOdbiorcy(String nazwaOdbiorcy) {
        this.nazwaOdbiorcy = nazwaOdbiorcy;
    }
}
