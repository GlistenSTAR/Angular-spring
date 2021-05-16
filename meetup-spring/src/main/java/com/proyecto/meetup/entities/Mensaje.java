package com.proyecto.meetup.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Mensaje")

    private Long idMensaje;
    @Column(name="Descripcion")
    private String descripcion;
    @Column(name="Adjunto")
    private String adjunto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Id_TipoMensaje")
    private TipoMensaje tipoMensaje;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Id_Miembro")
    private Miembro miembro;

    public Mensaje(){

    }

    public Long getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Long idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public TipoMensaje getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(TipoMensaje tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "idMensaje=" + idMensaje +
                ", descripcion='" + descripcion + '\'' +
                ", adjunto='" + adjunto + '\'' +
                ", tipoMensaje=" + tipoMensaje +
                ", miembro=" + miembro +
                '}';
    }
}
