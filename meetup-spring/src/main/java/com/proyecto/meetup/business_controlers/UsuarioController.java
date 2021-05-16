package com.proyecto.meetup.business_controlers;

import com.proyecto.meetup.dtos.UsuarioMinimoDto;
import com.proyecto.meetup.entities.Ciudad;
import com.proyecto.meetup.entities.Usuario;
import com.proyecto.meetup.repositories.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    public List<Usuario> listarUsuarios() {
        return this.usuarioDao.findAll();
    }

    public List<UsuarioMinimoDto> listarUsuariosMin() {
        List<Usuario> usuarios = (List<Usuario>) usuarioDao.findAll();
        List<UsuarioMinimoDto> dtos = new ArrayList<>();

        for(Usuario usuario : usuarios){
           dtos.add(new UsuarioMinimoDto(usuario.getIdUsuario(),usuario.getUsername(),usuario.getEmail(),usuario.getPassword(),usuario.getFechaNacimiento(),usuario.getCiudad()));
        }
        return  dtos;
    }

    public Usuario listarUsuarioId(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    public Usuario crearUsuario(Usuario usuario){
        //Pendiente validaciones
        this.usuarioDao.save(usuario);
        return usuario;
    }

    public UsuarioMinimoDto crearUsuarioMin(UsuarioMinimoDto usuarioMinimoDto){
        //Pendiente validaciones
        Usuario usuarioMin = Usuario.builder().username(usuarioMinimoDto.getUsername()).email(usuarioMinimoDto.getEmail()).password(usuarioMinimoDto.getPassword()).fechaNacimiento(usuarioMinimoDto.getFechaNacimiento()).ciudad(usuarioMinimoDto.getCiudad()).build();
        this.usuarioDao.save(usuarioMin);
        return new UsuarioMinimoDto(usuarioMin.getIdUsuario(),usuarioMin.getUsername(),usuarioMin.getEmail(),usuarioMin.getPassword(),usuarioMin.getFechaNacimiento(),usuarioMin.getCiudad());
    }

    public Usuario modificarUsuarioId(Usuario usuario){
        //Pendiente validaciones
        this.usuarioDao.save(usuario);
        return usuario;
    }

    public void eliminarUsuarioId(Long id){
        this.usuarioDao.deleteById(id);
    }

}
