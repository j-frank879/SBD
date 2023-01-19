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
}
