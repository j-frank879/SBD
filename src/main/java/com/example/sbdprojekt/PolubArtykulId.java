package com.example.sbdprojekt;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PolubArtykulId implements Serializable {
    private static final long serialVersionUID = -5185280252152727556L;
    @Column(name = "NAZWA_UZYTKOWNIK", nullable = false, length = 30)
    private String nazwaUzytkownik;

    @Column(name = "ID_ARTYKUL", nullable = false)
    private Long idArtykul;

    public String getNazwaUzytkownik() {
        return nazwaUzytkownik;
    }

    public void setNazwaUzytkownik(String nazwaUzytkownik) {
        this.nazwaUzytkownik = nazwaUzytkownik;
    }

    public Long getIdArtykul() {
        return idArtykul;
    }

    public void setIdArtykul(Long idArtykul) {
        this.idArtykul = idArtykul;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PolubArtykulId entity = (PolubArtykulId) o;
        return Objects.equals(this.nazwaUzytkownik, entity.nazwaUzytkownik) &&
                Objects.equals(this.idArtykul, entity.idArtykul);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwaUzytkownik, idArtykul);
    }

}