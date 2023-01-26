package com.example.entity;

import javax.persistence.*;

@Entity
public class Artykul extends Publikacja{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int state;
    String content;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    enum State{
        unpublished,
        published,
        archived
    }
}
