package com.proyecto.meetup.dtos;

import com.proyecto.meetup.entities.Miembro;
import com.proyecto.meetup.entities.Tema;
import com.proyecto.meetup.entities.TipoMensaje;
import com.proyecto.meetup.entities.Usuario;

import java.util.Date;

public class GrupoDto extends GrupoMinimoDto{

    private Date fecha;

    private Tema tema;

    private Usuario usuario;

    public GrupoDto(Long idGrupo, String titulo, Date fecha, Tema tema, Usuario usuario){
        super(idGrupo,titulo);
        this.fecha=fecha;
        this.tema=tema;
        this.usuario=usuario;
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
        return "GrupoDto{" +
                "fecha=" + fecha +
                ", tema=" + tema +
                ", usuario=" + usuario +
                '}';
    }
}
