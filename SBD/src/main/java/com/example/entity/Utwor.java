package com.example.entity;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "utwor")
public class Utwor extends Publikacja implements IUtwor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String opis;
    @Lob
    byte[] utwor;
    
    
    public Utwor() throws MalformedURLException
    {   
        super();
    }
    
    public Utwor(Long id, String opis, byte [] utwor,String nazwa,Date dataPrzeslania, String nazwaAutora)
    {
        this.id=id;
        this.opis=opis;
        this.utwor=utwor;
        this.setNazwa(nazwa);
        this.setdataPrzeslania(dataPrzeslania);
        this.setnazwaAutora(nazwaAutora);
        
    }
    public Long getId()
    {
        return id;
    }
    public String getOpis()
    {
       
        return opis;
    }
    public byte[] getUtwor()
    {
        return utwor;
    }
    public void setId(Long id)
    {
        this.id=id;
    }
    public void setOpis(String opis)
    {
        this.opis=opis;
    }
    public void setUtwor(byte[] utwor)
    {
        this.utwor=utwor;
        
    }

}
