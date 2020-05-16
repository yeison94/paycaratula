package com.api.paycaratula.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Caratula {

    private Tomador tomador;
    private Vehiculo vehiculo;
    private Seguro seguro;
}
