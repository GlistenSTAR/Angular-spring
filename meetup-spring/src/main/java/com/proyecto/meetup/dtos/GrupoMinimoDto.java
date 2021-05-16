package com.proyecto.meetup.dtos;

import com.sun.istack.NotNull;

public class GrupoMinimoDto {

    @NotNull
    private Long idGrupo;

    @NotNull
    private String titulo;

    public GrupoMinimoDto(){
        this.titulo="";
    }

    public GrupoMinimoDto(Long idGrupo, String titulo){
        this.idGrupo=idGrupo;
        this.titulo=titulo;
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

    @Override
    public String toString() {
        return "GrupoMinimoDto{" +
                "idGrupo=" + idGrupo +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
