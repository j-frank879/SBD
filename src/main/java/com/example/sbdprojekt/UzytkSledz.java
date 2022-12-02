package com.example.sbdprojekt;

import javax.persistence.*;

@Entity
@Table(name = "UZYTK_SLEDZ")
public class UzytkSledz {
    @EmbeddedId
    private UzytkSledzId id;

    @MapsId("nazwaUzytkownik")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NAZWA_UZYTKOWNIK", nullable = false)
    private Uzytkownik nazwaUzytkownik;

    @MapsId("uzytkownikSledzony")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UZYTKOWNIK_SLEDZONY", nullable = false)
    private Uzytkownik uzytkownikSledzony;

    public UzytkSledzId getId() {
        return id;
    }

    public void setId(UzytkSledzId id) {
        this.id = id;
    }

    public Uzytkownik getNazwaUzytkownik() {
        return nazwaUzytkownik;
    }

    public void setNazwaUzytkownik(Uzytkownik nazwaUzytkownik) {
        this.nazwaUzytkownik = nazwaUzytkownik;
    }

    public Uzytkownik getUzytkownikSledzony() {
        return uzytkownikSledzony;
    }

    public void setUzytkownikSledzony(Uzytkownik uzytkownikSledzony) {
        this.uzytkownikSledzony = uzytkownikSledzony;
    }

}