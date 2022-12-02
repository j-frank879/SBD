package com.example.sbdprojekt;

import javax.persistence.*;

@Entity
@Table(name = "\"Polub/Artykul\"")
public class PolubArtykul {
    @EmbeddedId
    private PolubArtykulId id;

    @MapsId("nazwaUzytkownik")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NAZWA_UZYTKOWNIK", nullable = false)
    private Uzytkownik nazwaUzytkownik;

    @MapsId("idArtykul")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ARTYKUL", nullable = false)
    private Artykul idArtykul;

    public PolubArtykulId getId() {
        return id;
    }

    public void setId(PolubArtykulId id) {
        this.id = id;
    }

    public Uzytkownik getNazwaUzytkownik() {
        return nazwaUzytkownik;
    }

    public void setNazwaUzytkownik(Uzytkownik nazwaUzytkownik) {
        this.nazwaUzytkownik = nazwaUzytkownik;
    }

    public Artykul getIdArtykul() {
        return idArtykul;
    }

    public void setIdArtykul(Artykul idArtykul) {
        this.idArtykul = idArtykul;
    }

}