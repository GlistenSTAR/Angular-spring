package com.proyecto.meetup.rest_controllers;

import com.proyecto.meetup.business_controlers.TipoMensajeController;
import com.proyecto.meetup.entities.TipoMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class TipoMensajeRestController {

    @Autowired
    private TipoMensajeController tipoMensajeController;

    @GetMapping("/tipoMensajes")
    public List<TipoMensaje> listarTipoMensajes() {
        return this.tipoMensajeController.listarTipoMensajes();
    };

    @GetMapping("/tipoMensaje/{id}")
    public ResponseEntity<?> listarTipoMensajeId(@PathVariable Long id){
        TipoMensaje tipoMensaje = null;
        Map<String, Object> response = new HashMap<>();
        try {
            tipoMensaje =tipoMensajeController.listarTipoMensajeId(id);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(tipoMensaje ==null) {
            response.put("mensaje", "El tipoMensaje ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TipoMensaje>(tipoMensaje, HttpStatus.OK);
    }

    @PostMapping("/tipoMensaje")
    public ResponseEntity<?> crearTipoMensaje(@RequestBody TipoMensaje  tipoMensaje){
        TipoMensaje crearTipoMensaje=null;
        Map<String, Object> response = new HashMap<>();
        try {
            crearTipoMensaje =tipoMensajeController.crearTipoMensaje(tipoMensaje);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El tipoMensaje ha sido creada con éxito!");
        response.put("tipoMensaje", crearTipoMensaje);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @PutMapping("/tipoMensaje/{id}")
    public ResponseEntity<?> modificarTipoMensajeId(@RequestBody TipoMensaje  tipoMensaje, @PathVariable Long id){
        TipoMensaje tipoMensajeActual = tipoMensajeController.listarTipoMensajeId(id);
        TipoMensaje tipoMensajeUpdate = null;
        Map<String, Object> response = new HashMap<>();

        if(tipoMensajeActual ==null) {
            response.put("mensaje", "Error: no se puede editar, El tipoMensaje ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            tipoMensajeActual.setDescripcion(tipoMensaje.getDescripcion());
            tipoMensajeUpdate = tipoMensajeController.modificarTipoMensajeId(tipoMensajeActual);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al actualizar en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El tipoMensaje ha sido modificado con éxito!");
        response.put("tipoMensaje", tipoMensajeUpdate);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/tipoMensaje/{id}")
    public ResponseEntity<?> eliminarTipoMensajeId(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try {
            tipoMensajeController.eliminarTipoMensajeId(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al eliminar el tipoMensaje de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El tipoMensaje ha sido eliminado con éxito!");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
}
