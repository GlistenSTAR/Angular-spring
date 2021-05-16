package com.proyecto.meetup.data_services;

import com.proyecto.meetup.entities.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseGraph {

    private List<Ciudad> ciudadList;
    private List<Grupo> grupoList;
    private List<Mensaje> mensajeList;
    private List<Miembro> miembroList;
    private List<Tema> temaList;
    private List<TemaUsuario> temaUsuarioList;
    private List<TipoMensaje> tipoMensajeList;
    private List<Usuario> usuarioList;

    public DatabaseGraph(){
        this.ciudadList= new ArrayList<>();
        this.grupoList= new ArrayList<>();
        this.mensajeList= new ArrayList<>();
        this.mensajeList= new ArrayList<>();
        this.temaList= new ArrayList<>();
        this.temaUsuarioList= new ArrayList<>();
        this.tipoMensajeList= new ArrayList<>();
        this.usuarioList= new ArrayList<>();
    }

    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    public List<Miembro> getMiembroList() {
        return miembroList;
    }

    public void setMiembroList(List<Miembro> miembroList) {
        this.miembroList = miembroList;
    }

    public List<Tema> getTemaList() {
        return temaList;
    }

    public void setTemaList(List<Tema> temaList) {
        this.temaList = temaList;
    }

    public List<TemaUsuario> getTemaUsuarioList() {
        return temaUsuarioList;
    }

    public void setTemaUsuarioList(List<TemaUsuario> temaUsuarioList) {
        this.temaUsuarioList = temaUsuarioList;
    }

    public List<TipoMensaje> getTipoMensajeList() {
        return tipoMensajeList;
    }

    public void setTipoMensajeList(List<TipoMensaje> tipoMensajeList) {
        this.tipoMensajeList = tipoMensajeList;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
}
