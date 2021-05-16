package com.proyecto.meetup.rest_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MiembroRestController.MIEMBROS)
public class MiembroRestController {

    public static final String MIEMBROS = "/miembros";
}
