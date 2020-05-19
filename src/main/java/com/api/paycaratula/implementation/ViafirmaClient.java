package com.api.paycaratula.implementation;

import com.api.paycaratula.domain.viafirma.Body;
import com.api.paycaratula.domain.viafirma.Response;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Collections;


public class ViafirmaClient {


    public Mono<Response> creardocumento(String url, Body body) {

        String json_string = new Gson().toJson(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization","Basic Y29tLnZpYWZpcm1hLmRvY3VtZW50cy5hcGkuc2FtcGxlOkRNQ1RIXzI2MzM4OQ==");

        HttpEntity<String> request = new HttpEntity<String>(json_string, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = null;

        try {

            response = restTemplate.exchange(
                    url,
                    HttpMethod.POST, request,
                    String.class);

            System.out.println();

        }catch (Exception e){
            System.err.println();
        }

        Response respuestacreacion = new Response();
        respuestacreacion.setId(response.getBody());

        return Mono.just(respuestacreacion);
    }

}
