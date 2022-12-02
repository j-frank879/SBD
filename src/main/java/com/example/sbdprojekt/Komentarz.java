package com.example.sbdprojekt;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "KOMENTARZ")
public class Komentarz {
    @Id
    @Column(name = "ID_KOMENTARZ", nullable = false)
    private Long id;

    @Column(name = "DATA_PUBLIKACJI", nullable = false)
    private LocalDate dataPublikacji;

    @Column(name = "TRESC", nullable = false, length = 150)
    private String tresc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NAZWA_UZYTKOWNIK", nullable = false)
    private Uzytkownik nazwaUzytkownik;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_UTWOR", nullable = false)
    private Utwor idUtwor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ARTYKUL", nullable = false)
    private Artykul idArtykul;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataPublikacji() {
        return dataPublikacji;
    }

    public void setDataPublikacji(LocalDate dataPublikacji) {
        this.dataPublikacji = dataPublikacji;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
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

    public Artykul getIdArtykul() {
        return idArtykul;
    }

    public void setIdArtykul(Artykul idArtykul) {
        this.idArtykul = idArtykul;
    }

}