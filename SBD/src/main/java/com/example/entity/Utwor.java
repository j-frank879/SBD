package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utwor extends Publikacja
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String opis;
    byte[] utwor;
}
