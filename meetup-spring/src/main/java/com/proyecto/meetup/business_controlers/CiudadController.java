package com.proyecto.meetup.business_controlers;

import com.proyecto.meetup.entities.Ciudad;
import com.proyecto.meetup.repositories.CiudadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class CiudadController {

    @Autowired
    private CiudadDao ciudadDao;

    public List<Ciudad> listarCiudades() {
        return this.ciudadDao.findAll();
    }

    public List<Ciudad> buscarCiudadPorNombre(String nombre){
        return this.ciudadDao.findByNombreContainingIgnoreCase(nombre);
    }

    public Ciudad listarCiudadId(Long id) {
        return ciudadDao.findById(id).orElse(null);
    }

    public Ciudad crearCiudad(Ciudad ciudad){
        //Pendiente validaciones
        this.ciudadDao.save(ciudad);
        return ciudad;
    }

    public Ciudad modificarCiudadId(Ciudad ciudad){
        //Pendiente validaciones
        this.ciudadDao.save(ciudad);
        return ciudad;
    }

    public void eliminarCiudadId(Long id){
        this.ciudadDao.deleteById(id);
    }
}
