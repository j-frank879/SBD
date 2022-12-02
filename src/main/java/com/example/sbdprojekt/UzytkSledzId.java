package com.example.sbdprojekt;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UzytkSledzId implements Serializable {
    private static final long serialVersionUID = -7455065416509694754L;
    @Column(name = "NAZWA_UZYTKOWNIK", nullable = false, length = 30)
    private String nazwaUzytkownik;

    @Column(name = "UZYTKOWNIK_SLEDZONY", nullable = false, length = 30)
    private String uzytkownikSledzony;

    public String getNazwaUzytkownik() {
        return nazwaUzytkownik;
    }

    public void setNazwaUzytkownik(String nazwaUzytkownik) {
        this.nazwaUzytkownik = nazwaUzytkownik;
    }

    public String getUzytkownikSledzony() {
        return uzytkownikSledzony;
    }

    public void setUzytkownikSledzony(String uzytkownikSledzony) {
        this.uzytkownikSledzony = uzytkownikSledzony;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UzytkSledzId entity = (UzytkSledzId) o;
        return Objects.equals(this.nazwaUzytkownik, entity.nazwaUzytkownik) &&
                Objects.equals(this.uzytkownikSledzony, entity.uzytkownikSledzony);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwaUzytkownik, uzytkownikSledzony);
    }

}