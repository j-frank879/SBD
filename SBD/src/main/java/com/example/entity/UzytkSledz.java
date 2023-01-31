package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UzytkSledz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nazwaUzytkownika;
    String uzytkownikSledzony;

    public void setNazwaUzytkownika(String nazwaUzytkownika) {
        this.nazwaUzytkownika = nazwaUzytkownika;
    }
    public void setUzytkownikSledzony(String uzytkownikSledzony) {
        this.uzytkownikSledzony = uzytkownikSledzony;
    }
    public String getUzytkownikSledzony(){return uzytkownikSledzony;}
    public String getNazwaUzytkownika(){return nazwaUzytkownika;}
}
