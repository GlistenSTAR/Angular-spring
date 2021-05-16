package com.proyecto.meetup.rest_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MensajeRestController.MENSAJES)
public class MensajeRestController {

    public static final String MENSAJES = "/mensajes";


}
