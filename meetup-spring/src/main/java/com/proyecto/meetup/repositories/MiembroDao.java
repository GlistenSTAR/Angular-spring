package com.proyecto.meetup.repositories;

import com.proyecto.meetup.entities.Miembro;
import org.springframework.data.repository.CrudRepository;

public interface MiembroDao extends CrudRepository<Miembro,Long>

    {
}
