package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Uzytkownik implements  IUzytkownik
{
    @Id
    String nazwa;
    String haslo;
    Boolean blokada;
    String email;
    String rola; //Idk czy tak mialo byc
}
