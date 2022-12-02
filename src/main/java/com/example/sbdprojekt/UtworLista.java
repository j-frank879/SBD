package com.example.sbdprojekt;

import javax.persistence.*;

@Entity
@Table(name = "\"Utwor/Lista\"")
public class UtworLista {
    @EmbeddedId
    private UtworListaId id;

    @MapsId("idLista")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_LISTA", nullable = false)
    private Lista idLista;

    @MapsId("idUtwor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_UTWOR", nullable = false)
    private Utwor idUtwor;

    public UtworListaId getId() {
        return id;
    }

    public void setId(UtworListaId id) {
        this.id = id;
    }

    public Lista getIdLista() {
        return idLista;
    }

    public void setIdLista(Lista idLista) {
        this.idLista = idLista;
    }

    public Utwor getIdUtwor() {
        return idUtwor;
    }

    public void setIdUtwor(Utwor idUtwor) {
        this.idUtwor = idUtwor;
    }

}