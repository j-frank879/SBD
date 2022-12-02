package com.example.sbdprojekt;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WIADOMOSC")
public class Wiadomosc {
    @Id
    @Column(name = "ID_WIADOMOSC", nullable = false)
    private Long id;

    @Column(name = "DATA_WYSLANIA", nullable = false)
    private LocalDate dataWyslania;

    @Column(name = "TRESC", nullable = false, length = 150)
    private String tresc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NAZWA_NADAWCY", nullable = false)
    private Uzytkownik nazwaNadawcy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NAZWA_ODBIORCY1", nullable = false)
    private Uzytkownik nazwaOdbiorcy1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataWyslania() {
        return dataWyslania;
    }

    public void setDataWyslania(LocalDate dataWyslania) {
        this.dataWyslania = dataWyslania;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Uzytkownik getNazwaNadawcy() {
        return nazwaNadawcy;
    }

    public void setNazwaNadawcy(Uzytkownik nazwaNadawcy) {
        this.nazwaNadawcy = nazwaNadawcy;
    }

    public Uzytkownik getNazwaOdbiorcy1() {
        return nazwaOdbiorcy1;
    }

    public void setNazwaOdbiorcy1(Uzytkownik nazwaOdbiorcy1) {
        this.nazwaOdbiorcy1 = nazwaOdbiorcy1;
    }

}