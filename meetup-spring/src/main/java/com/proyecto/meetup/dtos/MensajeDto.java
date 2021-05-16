package com.proyecto.meetup.dtos;

import com.proyecto.meetup.entities.Miembro;
import com.proyecto.meetup.entities.TipoMensaje;

public class MensajeDto extends MensajeMinimoDto{

    private Miembro miembro;
    private TipoMensaje tipoMensaje;

    public MensajeDto(Long idMensaje, String descripcion, Miembro miembro, TipoMensaje tipoMensaje ){
        super(idMensaje,descripcion);
        this.miembro=miembro;
        this.tipoMensaje=tipoMensaje;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public TipoMensaje getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(TipoMensaje tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    @Override
    public String toString() {
        return "MensajeDto{" +
                "miembro=" + miembro +
                ", tipoMensaje=" + tipoMensaje +
                '}';
    }
}
