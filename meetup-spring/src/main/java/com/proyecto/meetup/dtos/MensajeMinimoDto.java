package com.proyecto.meetup.dtos;

import com.sun.istack.NotNull;

public class MensajeMinimoDto {

    @NotNull
    private Long idMensaje;

    @NotNull
    private String descripcion;

    public MensajeMinimoDto(){
            this.descripcion="";
    }

    public MensajeMinimoDto(Long idMensaje, String descripcion){
        this.idMensaje=idMensaje;
        this.descripcion=descripcion;
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

    @Override
    public String toString() {
        return "MensajeMinimoDto{" +
                "idMensaje=" + idMensaje +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
