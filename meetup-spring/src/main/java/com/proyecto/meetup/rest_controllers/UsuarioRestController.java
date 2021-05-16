package com.proyecto.meetup.rest_controllers;

import com.proyecto.meetup.business_controlers.CiudadController;
import com.proyecto.meetup.business_controlers.UsuarioController;
import com.proyecto.meetup.dtos.UsuarioDto;
import com.proyecto.meetup.dtos.UsuarioMinimoDto;
import com.proyecto.meetup.entities.Ciudad;
import com.proyecto.meetup.entities.Usuario;
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
public class UsuarioRestController {

    @Autowired
    private UsuarioController usuarioController;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return this.usuarioController.listarUsuarios();
    };

    @GetMapping("/usuariosMin")
    public List<UsuarioMinimoDto> listarUsuariosMin() {
        return this.usuarioController.listarUsuariosMin();
    };

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> listarUsuarioId(@PathVariable Long id){
        Usuario usuario = null;
        Map<String, Object> response = new HashMap<>();
        try {
            usuario =usuarioController.listarUsuarioId(id);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(usuario ==null) {
            response.put("mensaje", "El Usuario ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario  usuario){
        Usuario crearUsuario=null;
        Map<String, Object> response = new HashMap<>();
        try {
            crearUsuario =usuarioController.crearUsuario(usuario);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El usuario ha sido creado con éxito!");
        response.put("usuario", crearUsuario);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @PostMapping("/usuariosMin")
    public ResponseEntity<?> crearUsuarioMin(@RequestBody UsuarioMinimoDto usuarioMinimoDtou){
        UsuarioMinimoDto crearUsuarioMin=null;
        Map<String, Object> response = new HashMap<>();
        try {
            crearUsuarioMin =usuarioController.crearUsuarioMin(usuarioMinimoDtou);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El usuarioMin ha sido creado con éxito!");
        response.put("usuario", crearUsuarioMin);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<?> modificarUsuarioId(@RequestBody Usuario  usuario, @PathVariable Long id){
        Usuario usuarioActual = usuarioController.listarUsuarioId(id);
        Usuario usuarioUpdate = null;
        Map<String, Object> response = new HashMap<>();

        if(usuarioActual ==null) {
            response.put("mensaje", "Error: no se puede editar, El Usuario ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            usuarioActual.setNombres(usuario.getNombres());
            usuarioActual.setApellidos(usuario.getApellidos());
            usuarioActual.setUsername(usuario.getUsername());
            usuarioActual.setPassword(usuario.getPassword());
            usuarioActual.setEmail(usuario.getEmail());
            usuarioActual.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioActual.setTelefono(usuario.getTelefono());
            usuarioActual.setDireccion(usuario.getDireccion());
            usuarioActual.setLatitud(usuario.getLatitud());
            usuarioActual.setLongitud(usuario.getLongitud());
            usuarioActual.setCiudad(usuario.getCiudad());

            usuarioUpdate = usuarioController.modificarUsuarioId(usuarioActual);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al actualizar en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Usuario ha sido modificado con éxito!");
        response.put("usuario", usuarioUpdate);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> eliminarUsuarioId(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try {
            usuarioController.eliminarUsuarioId(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al eliminar el usuario de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El usuario ha sido eliminado con éxito!");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }

}
