package com.example.controllers.adapter;

import com.example.entity.Artykul;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ArtykulAdapter {
    private Artykul adaptee;

    public ArtykulAdapter(Artykul adaptee){
        this.adaptee = adaptee;
    }

    public Long getId() {
        return adaptee.getId();
    }

    public String getNazwa()
    {
        return adaptee.getNazwa();
    }
    public Date getdataPrzeslania()
    {
        return adaptee.getdataPrzeslania();
    }
    public String getnazwaAutora()
    {
        return adaptee.getnazwaAutora();
    }
    public void setNazwa(String nazwa)
    {
        adaptee.setNazwa(nazwa);
    }
    public void setdataPrzeslania(Date dataPrzeslania)
    {
        adaptee.setdataPrzeslania(dataPrzeslania);
    }
    public void setnazwaAutora(String nazwaAutora)
    {
        adaptee.setnazwaAutora(nazwaAutora);
    }

    public String getContent() {
        try {
            return new String(adaptee.getContent(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setId(Long id) {
        adaptee.setId(id);
    }

    public void setContent(String content) {
        adaptee.setContent(content.getBytes(StandardCharsets.UTF_8));
    }

    public int getState() {
        return adaptee.getState();
    }

    public void setState(int state) {
        adaptee.setState(state);
    }
}
