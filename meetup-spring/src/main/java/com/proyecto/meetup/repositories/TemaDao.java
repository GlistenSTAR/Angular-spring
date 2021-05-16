package com.proyecto.meetup.repositories;

import com.proyecto.meetup.entities.Tema;
import org.springframework.data.repository.CrudRepository;

public interface TemaDao extends CrudRepository<Tema,Long> {

}
