package com.example.sbdprojekt;

import javax.persistence.*;

@Entity
@Table(name = "LISTA")
public class Lista {
    @Id
    @Column(name = "ID_LISTA", nullable = false)
    private Long id;

    @Column(name = "NAZWA_LISTA", nullable = false, length = 30)
    private String nazwaLista;

    @Column(name = "PUBLICZNA", nullable = false)
    private Boolean publiczna = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NAZWA_UZYTKOWNIK", nullable = false)
    private Uzytkownik nazwaUzytkownik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaLista() {
        return nazwaLista;
    }

    public void setNazwaLista(String nazwaLista) {
        this.nazwaLista = nazwaLista;
    }

    public Boolean getPubliczna() {
        return publiczna;
    }

    public void setPubliczna(Boolean publiczna) {
        this.publiczna = publiczna;
    }

    public Uzytkownik getNazwaUzytkownik() {
        return nazwaUzytkownik;
    }

    public void setNazwaUzytkownik(Uzytkownik nazwaUzytkownik) {
        this.nazwaUzytkownik = nazwaUzytkownik;
    }

}