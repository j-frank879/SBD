package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artykul {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    enum state{
        unpublished,
        published
    }
}
