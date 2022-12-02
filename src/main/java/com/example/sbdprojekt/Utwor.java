package com.example.sbdprojekt;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "UTWOR")
public class Utwor {
    @Id
    @Column(name = "ID_UTWOR", nullable = false)
    private Long id;

    @Column(name = "NAZWA_UTWOR", nullable = false, length = 30)
    private String nazwaUtwor;

    @Column(name = "AUTOR", nullable = false, length = 30)
    private String autor;

    @Column(name = "OPIS", length = 150)
    private String opis;

    @Column(name = "DATA_PUBLIKACJI", nullable = false)
    private LocalDate dataPublikacji;

    @Column(name = "UTWOR")
    private byte[] utwor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NAZWA_UZYTKOWNIK", nullable = false)
    private Uzytkownik nazwaUzytkownik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaUtwor() {
        return nazwaUtwor;
    }

    public void setNazwaUtwor(String nazwaUtwor) {
        this.nazwaUtwor = nazwaUtwor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDate getDataPublikacji() {
        return dataPublikacji;
    }

    public void setDataPublikacji(LocalDate dataPublikacji) {
        this.dataPublikacji = dataPublikacji;
    }

    public byte[] getUtwor() {
        return utwor;
    }

    public void setUtwor(byte[] utwor) {
        this.utwor = utwor;
    }

    public Uzytkownik getNazwaUzytkownik() {
        return nazwaUzytkownik;
    }

    public void setNazwaUzytkownik(Uzytkownik nazwaUzytkownik) {
        this.nazwaUzytkownik = nazwaUzytkownik;
    }

}