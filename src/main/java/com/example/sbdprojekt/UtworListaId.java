package com.example.sbdprojekt;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UtworListaId implements Serializable {
    private static final long serialVersionUID = -7016216600779256890L;
    @Column(name = "ID_LISTA", nullable = false)
    private Long idLista;

    @Column(name = "ID_UTWOR", nullable = false)
    private Long idUtwor;

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
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
        UtworListaId entity = (UtworListaId) o;
        return Objects.equals(this.idUtwor, entity.idUtwor) &&
                Objects.equals(this.idLista, entity.idLista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtwor, idLista);
    }

}