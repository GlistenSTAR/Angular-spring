package com.proyecto.meetup.repositories;

import com.proyecto.meetup.entities.Grupo;
import org.springframework.data.repository.CrudRepository;

public interface GrupoDao extends CrudRepository<Grupo,Long> {
}
