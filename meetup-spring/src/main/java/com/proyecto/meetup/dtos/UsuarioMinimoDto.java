package com.proyecto.meetup.dtos;

import com.proyecto.meetup.entities.Ciudad;
import com.proyecto.meetup.entities.Usuario;
import com.sun.istack.NotNull;

import java.util.Date;

public class UsuarioMinimoDto {

    @NotNull
    private Long idUsuario;

    @NotNull
    private String username;

    private String email;

    private String password;

    private Date fechaNacimiento;

    private Ciudad ciudad;

    public UsuarioMinimoDto(Long idUsuario, String username, String email, String password, Date fechaNacimiento, Ciudad ciudad) {
        super();
        this.idUsuario = idUsuario;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "UsuarioMinimoDto{" +
                "idUsuario=" + idUsuario +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", ciudad=" + ciudad +
                '}';
    }
}
