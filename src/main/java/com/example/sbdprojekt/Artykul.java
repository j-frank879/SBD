package com.example.sbdprojekt;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ARTYKUL")
public class Artykul {
    @Id
    @Column(name = "ID_ARTYKUL", nullable = false)
    private Long id;

    @Column(name = "NAZWA_ARTYKUL", nullable = false, length = 30)
    private String nazwaArtykul;

    @Column(name = "DATA_PUBLIKACJI", nullable = false)
    private LocalDate dataPublikacji;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NAZWA_UZYTKOWNIK", nullable = false)
    private Uzytkownik nazwaUzytkownik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaArtykul() {
        return nazwaArtykul;
    }

    public void setNazwaArtykul(String nazwaArtykul) {
        this.nazwaArtykul = nazwaArtykul;
    }

    public LocalDate getDataPublikacji() {
        return dataPublikacji;
    }

    public void setDataPublikacji(LocalDate dataPublikacji) {
        this.dataPublikacji = dataPublikacji;
    }

    public Uzytkownik getNazwaUzytkownik() {
        return nazwaUzytkownik;
    }

    public void setNazwaUzytkownik(Uzytkownik nazwaUzytkownik) {
        this.nazwaUzytkownik = nazwaUzytkownik;
    }

}