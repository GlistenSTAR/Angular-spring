package com.proyecto.meetup.business_controlers;

import com.proyecto.meetup.entities.TipoMensaje;
import com.proyecto.meetup.repositories.TipoMensajeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class TipoMensajeController {

    @Autowired
    private TipoMensajeDao tipoMensajeDao;

    public List<TipoMensaje> listarTipoMensajes() {
        return this.tipoMensajeDao.findAll();
    }

    public TipoMensaje listarTipoMensajeId(Long id) {
        return tipoMensajeDao.findById(id).orElse(null);
    }

    public TipoMensaje crearTipoMensaje(TipoMensaje tipoMensaje){
        //Pendiente validaciones
        this.tipoMensajeDao.save(tipoMensaje);
        return tipoMensaje;
    }

    public TipoMensaje modificarTipoMensajeId(TipoMensaje tipoMensaje){
        //Pendiente validaciones
        this.tipoMensajeDao.save(tipoMensaje);
        return tipoMensaje;
    }

    public void eliminarTipoMensajeId(Long id){
        this.tipoMensajeDao.deleteById(id);
    }
}
