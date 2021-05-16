package com.proyecto.meetup.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Grupo")
    private Long idGrupo;

    @Column(name="Titulo")
    private String titulo;
    @Column(name="Descripcion")
    private String descripcion;
    @Column(name="Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Id_Tema")
    private Tema tema;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Id_Usuario")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<Miembro> miembros;

    public Grupo(){
        this.miembros=new ArrayList<>();
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "idGrupo=" + idGrupo +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", tema=" + tema +
                ", usuario=" + usuario +
                '}';
    }
}
