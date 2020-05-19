package com.api.paycaratula.Service;

import com.api.paycaratula.domain.Caratula;
import com.api.paycaratula.implementation.CaratulaPDF;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class CaratulaService {

    @Autowired
    private CaratulaPDF caratulaPDF;

    public Mono<String> generar(Caratula caratula) throws IOException, JRException {

        return caratulaPDF.generar(caratula);

    }
}
