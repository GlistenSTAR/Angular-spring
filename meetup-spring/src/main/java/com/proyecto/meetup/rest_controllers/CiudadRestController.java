package com.proyecto.meetup.rest_controllers;

import com.proyecto.meetup.business_controlers.CiudadController;
import com.proyecto.meetup.entities.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class CiudadRestController {

    @Autowired
    private CiudadController ciudadController;

    @GetMapping("/ciudades")
    public List<Ciudad> listarCiudades() {
        return this.ciudadController.listarCiudades();
    };

    @GetMapping("/ciudades/filtrar-ciudades/{nombre}")
    public List<Ciudad> buscarCiudadPorNombre(@PathVariable String nombre) {
        return this.ciudadController.buscarCiudadPorNombre(nombre);
    };

    @GetMapping("/ciudades/{id}")
    public ResponseEntity<?> listarCiudadId(@PathVariable Long id){
        Ciudad ciudad = null;
        Map<String, Object> response = new HashMap<>();
        try {
            ciudad =ciudadController.listarCiudadId(id);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(ciudad ==null) {
            response.put("mensaje", "La ciudad ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Ciudad>(ciudad, HttpStatus.OK);
    }

    @PostMapping("/ciudades")
    public ResponseEntity<?> crearCiudad(@RequestBody Ciudad  ciudad){
        Ciudad crearCiudad=null;
        Map<String, Object> response = new HashMap<>();
        try {
            crearCiudad =ciudadController.crearCiudad(ciudad);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La ciudad ha sido creada con éxito!");
        response.put("ciudad", crearCiudad);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @PutMapping("/ciudad/{id}")
    public ResponseEntity<?> modificarCiudadId(@RequestBody Ciudad  ciudad, @PathVariable Long id){
        Ciudad ciudadActual = ciudadController.listarCiudadId(id);
        Ciudad ciudadUpdate = null;
        Map<String, Object> response = new HashMap<>();

        if(ciudadActual ==null) {
            response.put("mensaje", "Error: no se puede editar, La ciudad ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            ciudadActual.setNombre(ciudad.getNombre());
            ciudadUpdate = ciudadController.modificarCiudadId(ciudadActual);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al actualizar en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La ciudad ha sido modificada con éxito!");
        response.put("ciudad", ciudadUpdate);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/ciudades/{id}")
    public ResponseEntity<?> eliminarCiudadId(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try {
            ciudadController.eliminarCiudadId(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al eliminar la ciudad de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La ciudad ha sido eliminada con éxito!");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
}
