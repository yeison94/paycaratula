package com.api.paycaratula.controller;

import com.api.paycaratula.Service.CaratulaService;
import com.api.paycaratula.domain.Caratula;
import com.api.paycaratula.implementation.CaratulaPDF;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CaratulaController {

    @Autowired
    private CaratulaService caratulaService;

    @PostMapping("/caratulapdf")
    public Mono<String> caratulapdf(@RequestBody Caratula caratula) throws IOException, JRException {

        caratulaService.generar(caratula);

        return Mono.just("OK");

    }

}
