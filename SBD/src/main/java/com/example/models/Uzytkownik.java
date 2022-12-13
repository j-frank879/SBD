package com.example.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "UZYTKOWNIK")
public class Uzytkownik {
    public Uzytkownik() {
    }

    public Uzytkownik(String nazwa_uzytkownik, String haslo, boolean blokada, String email, String rola) {
        this.nazwa_uzytkownik = nazwa_uzytkownik;
        this.haslo = haslo;
        this.blokada = blokada;
        this.email = email;
        this.rola = rola;
    }

    @Id
    @Column(name = "nazwa_uzytkownik", nullable = false,length=30)
   // @NotBlank(message = "Login is mandatory")
    private String nazwa_uzytkownik;


    @Column(name = "haslo", nullable = false,length=30)
  //  @NotBlank(message = "Haslo is mandatory")
    private String haslo;
    @Column(name = "blokada")
    private boolean blokada;
    //@Email(message = "Login is mandatory")
   // @NotBlank(message = "Email is mandatory")
   @Column(name = "email", nullable = false,length = 40)
    private String email;
   @Column(name = "rola", nullable = false,length = 15)
    private String rola;



    public String getNazwa_uzytkownik() {
        return nazwa_uzytkownik;
    }

    public void setNazwa_uzytkownik(String nazwa_uzytkownik) {
        this.nazwa_uzytkownik = nazwa_uzytkownik;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public boolean isBlokada() {
        return blokada;
    }

    public void setBlokada(boolean blokada) {
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


    @Override
    public String toString() {
        return "Uzytkownik{" +
                "nazwa_uzytkownik='" + nazwa_uzytkownik + '\'' +
                ", haslo='" + haslo + '\'' +
                ", blokada=" + blokada +
                ", email='" + email + '\'' +
                ", rola='" + rola + '\'' +
                '}';
    }


}