package com.example.sbdprojekt;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PolubUtworId implements Serializable {
    private static final long serialVersionUID = -8723102548163138218L;
    @Column(name = "NAZWA_UZYTKOWNIK", nullable = false, length = 30)
    private String nazwaUzytkownik;

    @Column(name = "ID_UTWOR", nullable = false)
    private Long idUtwor;

    public String getNazwaUzytkownik() {
        return nazwaUzytkownik;
    }

    public void setNazwaUzytkownik(String nazwaUzytkownik) {
        this.nazwaUzytkownik = nazwaUzytkownik;
    }

    public Long getIdUtwor() {
        return idUtwor;
    }

    public void setIdUtwor(Long idUtwor) {
        this.idUtwor = idUtwor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PolubUtworId entity = (PolubUtworId) o;
        return Objects.equals(this.nazwaUzytkownik, entity.nazwaUzytkownik) &&
                Objects.equals(this.idUtwor, entity.idUtwor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwaUzytkownik, idUtwor);
    }

}