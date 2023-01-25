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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    
    public Uzytkownik()
    {
        
    }
    @Override
    public void dodajPiosenke() {
        // dodaj piosenke
        System.out.println("Udalo sie dodac!");
    }
    
    
}
