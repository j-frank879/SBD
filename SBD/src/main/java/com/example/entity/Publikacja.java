package com.example.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Publikacja {
    @Column
    private String nazwa;
    @Column
    private Date dataPrzeslania;
    @Column
    private String nazwaAutora;
    
    public Publikacja()
    {this.dataPrzeslania=new Date();
        
    }
    public Publikacja(String nazwa, Date dataPrzeslania, String nazwaAutora)
    {
        this.nazwa=nazwa;
        this.dataPrzeslania=dataPrzeslania;
        this.nazwaAutora=nazwaAutora;
    }
    public String getNazwa()
    {
        return nazwa;
    }
    public Date getdataPrzeslania()
    {
        return dataPrzeslania;
    }
    public String getnazwaAutora()
    {
        return nazwaAutora;
    }
    public void setNazwa(String nazwa)
    {
        this.nazwa=nazwa;
    }
    public void setdataPrzeslania(Date dataPrzeslania)
    {
        this.dataPrzeslania=dataPrzeslania;
    }
    public void setnazwaAutora(String nazwaAutora)
    {
        this.nazwaAutora=nazwaAutora;
    }
}
