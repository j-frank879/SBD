package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Komentarz
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date dataPublikacji;
    String tresc;
    String nazwaUzytkownika; //Znowu foreign key
}
