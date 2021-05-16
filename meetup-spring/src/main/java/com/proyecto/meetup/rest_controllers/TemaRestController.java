package com.proyecto.meetup.rest_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TemaRestController.TEMAS)
public class TemaRestController {

    public static final String TEMAS = "/temas";
}
