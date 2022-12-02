package com.example.sbdprojekt;

import javax.persistence.*;

@Entity
@Table(name = "\"Polub/Utwor\"")
public class PolubUtwor {
    @EmbeddedId
    private PolubUtworId id;

    @MapsId("nazwaUzytkownik")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NAZWA_UZYTKOWNIK", nullable = false)
    private Uzytkownik nazwaUzytkownik;

    @MapsId("idUtwor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_UTWOR", nullable = false)
    private Utwor idUtwor;

    public PolubUtworId getId() {
        return id;
    }

    public void setId(PolubUtworId id) {
        this.id = id;
    }

    public Uzytkownik getNazwaUzytkownik() {
        return nazwaUzytkownik;
    }

    public void setNazwaUzytkownik(Uzytkownik nazwaUzytkownik) {
        this.nazwaUzytkownik = nazwaUzytkownik;
    }

    public Utwor getIdUtwor() {
        return idUtwor;
    }

    public void setIdUtwor(Utwor idUtwor) {
        this.idUtwor = idUtwor;
    }

}