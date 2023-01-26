package com.example.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Publikacja {
    String nazwa;
    String dataPrzeslania;
    String nazwaAutora;

    public String getNazwa() {
        return nazwa;
    }

    public String getDataPrzeslania() {
        return dataPrzeslania;
    }

    public String getNazwaAutora() {
        return nazwaAutora;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setDataPrzeslania(String dataPrzeslania) {
        this.dataPrzeslania = dataPrzeslania;
    }

    public void setNazwaAutora(String nazwaAutora) {
        this.nazwaAutora = nazwaAutora;
    }
}
