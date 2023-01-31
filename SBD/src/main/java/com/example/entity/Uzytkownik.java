package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Uzytkownik implements  IUzytkownik
{
    @Id
    @Column
    private String nazwa;
    @Column
    private String haslo;
    @Column
    private Boolean blokada;
    @Column
    private String email;
    @Column
    private int rola; //Idk czy tak mialo byc

    enum Rola{
        admin,
        user,
        redactor
    }
    
    public Uzytkownik()
    {
        
    }
    @Override
    public boolean dodajPiosenke() {
        return true;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Boolean getBlokada() {
        return blokada;
    }

    public void setBlokada(Boolean blokada) {
        this.blokada = blokada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRola() {
        return rola;
    }

    public void setRola(int rola) {
        this.rola = rola;
    }
}
