package com.proyecto.meetup.repositories;

import com.proyecto.meetup.dtos.UsuarioDto;
import com.proyecto.meetup.dtos.UsuarioMinimoDto;
import com.proyecto.meetup.entities.Ciudad;
import com.proyecto.meetup.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UsuarioDao extends CrudRepository<Usuario,Long> {

    List<Usuario> findAll();

}
