package com.proyecto.meetup.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tipo_Mensaje")
public class TipoMensaje implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_TipoMensaje")
    private Long idTipoMensaje;
    @Column(name="Descripcion")
    private String descripcion;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoMensaje", cascade = CascadeType.ALL)
//    private List<Mensaje> mensajes;

    public TipoMensaje() {
        //this.mensajes=new ArrayList<>();
    }

    public Long getIdTipoMensaje() {
        return idTipoMensaje;
    }

    public void setIdTipoMensaje(Long idTipoMensaje) {
        this.idTipoMensaje = idTipoMensaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//    public List<Mensaje> getMensajes() {
//        return mensajes;
//    }
//
//    public void setMensajes(List<Mensaje> mensajes) {
//        this.mensajes = mensajes;
//    }

    @Override
    public String toString() {
        return "TipoMensaje{" +
                "idTipoMensaje=" + idTipoMensaje +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
