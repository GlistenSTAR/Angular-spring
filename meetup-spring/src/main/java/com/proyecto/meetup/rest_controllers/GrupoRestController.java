package com.proyecto.meetup.rest_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GrupoRestController.GRUPOS)
public class GrupoRestController {

    public static final String GRUPOS = "/grupos";
}
