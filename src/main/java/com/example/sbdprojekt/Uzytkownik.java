package com.example.sbdprojekt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UZYTKOWNIK")
public class Uzytkownik {
    @Id
    @Column(name = "NAZWA_UZYTKOWNIK", nullable = false, length = 30)
    private String id;

    @Column(name = "HASLO", nullable = false, length = 30)
    private String haslo;

    @Column(name = "BLOKADA")
    private Boolean blokada;

    @Column(name = "EMAIL", nullable = false, length = 40)
    private String email;

    @Column(name = "ROLA", nullable = false, length = 15)
    private String rola;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Boolean getBlokada() {
        return blokada;
    }

    public void setBlokada(Boolean blokada) {
        this.blokada = blokada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

}