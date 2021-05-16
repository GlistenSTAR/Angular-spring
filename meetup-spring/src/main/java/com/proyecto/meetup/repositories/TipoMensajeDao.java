package com.proyecto.meetup.repositories;

import com.proyecto.meetup.entities.TipoMensaje;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TipoMensajeDao extends CrudRepository<TipoMensaje,Long> {

    List<TipoMensaje> findAll();

}
