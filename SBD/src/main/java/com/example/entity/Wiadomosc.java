package com.example.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Wiadomosc
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date dataWyslania;
    String tresc;
    String nazwaNadawcy; //fk
    String nazwaOdbiorcy; //fk
}
