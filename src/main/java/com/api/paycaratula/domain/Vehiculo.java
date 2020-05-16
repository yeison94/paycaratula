package com.api.paycaratula.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Vehiculo {

    private String placa;
    private String modelo;
    private String marca;
    private String caracteristicas;
    private String clase;
    private String servicio;
    private String motor;
    private String chasis;
    private Float valAccesorios;
}
