package com.example.entity;

import javax.persistence.*;

@Entity
public class Artykul extends Publikacja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    byte[] content;

    public Long getId() {
        return id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    enum state{
        unpublished,
        published
    }
}
