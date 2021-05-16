package com.proyecto.meetup.repositories;

import com.proyecto.meetup.entities.Ciudad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CiudadDao extends CrudRepository<Ciudad,Long> {

   List<Ciudad> findAll();

   //Métodos para buscar una ciudad por nombre
   //Opcion 1:
   @Query("select c from Ciudad c where c.nombre like %?1%")
   List<Ciudad> buscarCiudadPorNombre(String nombre);

   //Opcion 2:
   List<Ciudad> findByNombreContainingIgnoreCase(String nombre);
   
}
