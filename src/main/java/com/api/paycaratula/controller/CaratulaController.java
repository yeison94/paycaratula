package com.api.paycaratula.controller;

import com.api.paycaratula.Service.CaratulaService;
import com.api.paycaratula.Service.ViafirmaService;
import com.api.paycaratula.domain.Caratula;
import com.api.paycaratula.domain.viafirma.Response;
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

    @Autowired
    private ViafirmaService viafirmaService;

    @PostMapping("/caratulapdf")
    public Mono<String> caratulapdf(@RequestBody Caratula caratula) throws IOException, JRException {

        caratulaService.generar(caratula);

        return Mono.just("OK");

    }

    @PostMapping("/firmacaratula")
    public Mono<Response> firmacaratula(@RequestBody Caratula caratula) throws IOException, JRException {

        Mono<String> pdf = caratulaService.generar(caratula);

        String base64 = pdf.block();

        return viafirmaService.firmaweb(base64,caratula.getTomador().getCorreoTomador());

    }



}
