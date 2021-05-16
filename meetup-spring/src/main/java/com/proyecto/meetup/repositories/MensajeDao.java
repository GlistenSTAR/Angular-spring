package com.proyecto.meetup.repositories;

import com.proyecto.meetup.entities.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface MensajeDao extends CrudRepository<Mensaje,Long> {
}
