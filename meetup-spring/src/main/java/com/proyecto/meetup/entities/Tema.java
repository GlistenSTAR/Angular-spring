package com.proyecto.meetup.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tema implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Tema")
    private Long idTema;

    @Column(name="Titulo")
    private String titulo;
    @Column(name="Foto")
    private String foto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tema", cascade = CascadeType.ALL)
    private List<Grupo> grupos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tema", cascade = CascadeType.ALL)
    private List<TemaUsuario> temaUsuarios;

    public Tema(){
        this.grupos=new ArrayList<>();
        this.temaUsuarios=new ArrayList<>();
    }

    public Long getIdTema() {
        return idTema;
    }

    public void setIdTema(Long idTema) {
        this.idTema = idTema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public List<TemaUsuario> getTemaUsuarios() {
        return temaUsuarios;
    }

    public void setTemaUsuarios(List<TemaUsuario> temaUsuarios) {
        this.temaUsuarios = temaUsuarios;
    }

    @Override
    public String toString() {
        return "Tema{" +
                "idTema=" + idTema +
                ", titulo='" + titulo + '\'' +
                ", foto='" + foto + '\'' +
                ", grupos=" + grupos +
                ", temaUsuarios=" + temaUsuarios +
                '}';
    }
}
