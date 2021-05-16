package com.proyecto.meetup.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;

    private String nombres;
    private String apellidos;
    private String username;
    private String password;
    private String email;
    @Column(name="fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private String telefono;
    private String direccion;
    private Double latitud;
    private Double longitud;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
//    private List<Grupo> grupos;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
//    private List<TemaUsuario> temaUsuarios;

    public Usuario(){
//        this.grupos=new ArrayList<>();
//        this.temaUsuarios=new ArrayList<>();
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

//    public List<Grupo> getGrupos() {
//        return grupos;
//    }
//
//    public void setGrupos(List<Grupo> grupos) {
//        this.grupos = grupos;
//    }
//
//    public List<TemaUsuario> getTemaUsuarios() {
//        return temaUsuarios;
//    }
//
//    public void setTemaUsuarios(List<TemaUsuario> temaUsuarios) {
//        this.temaUsuarios = temaUsuarios;
//    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", ciudad=" + ciudad +
                '}';
    }

    public static class Builder {
        private Usuario usuario;

        private Builder() {
            this.usuario = new Usuario();
        }

        public Builder idUsuario(Long idUsuario) {
            this.usuario.idUsuario = idUsuario;
            return this;
        }

        public Builder nombres(String nombres) {
            this.usuario.nombres = nombres;
            return this;
        }

        public Builder apellidos(String apellidos) {
            this.usuario.apellidos = apellidos;
            return this;
        }

        public Builder username(String username) {
            this.usuario.username = username;
            return this;
        }

        public Builder password(String password) {
            this.usuario.password = password;
            return this;
        }

        public Builder email(String email) {
            this.usuario.email = email;
            return this;
        }

        public Builder fechaNacimiento(Date fechaNacimiento) {
            this.usuario.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Builder telefono(String telefono) {
            this.usuario.telefono = telefono;
            return this;
        }

        public Builder direccion(String direccion) {
            this.usuario.direccion = direccion;
            return this;
        }

        public Builder latitud(Double latitud) {
            this.usuario.latitud = latitud;
            return this;
        }

        public Builder longitud(Double longitud) {
            this.usuario.longitud = longitud;
            return this;
        }

        public Builder ciudad(Ciudad ciudad) {
            this.usuario.ciudad = ciudad;
            return this;
        }

        public Usuario build() {
            return this.usuario;
        }
    }
}
