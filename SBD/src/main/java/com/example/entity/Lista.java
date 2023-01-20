package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lista
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nazwaLista;
    Boolean publiczna;
    String nazwaUzytkownika;
}
