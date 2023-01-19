package com.example.entity;

import javax.persistence.*;

@Entity
public class UtworLista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long idLista; //Do wykminienia jak klucze obce załatwiać
    Long idUtwor;
}
