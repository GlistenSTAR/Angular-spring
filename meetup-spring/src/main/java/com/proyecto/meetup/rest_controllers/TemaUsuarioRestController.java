package com.proyecto.meetup.rest_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TemaUsuarioRestController.TEMAS_USUARIOS)
public class TemaUsuarioRestController {

    public static final String TEMAS_USUARIOS = "/temasUsuarios";
}
