package com.api.paycaratula.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Seguro {

    private String plan;
    private String poliza;
    private float valor;
    private String feinicio;
    private String fefin;
}
