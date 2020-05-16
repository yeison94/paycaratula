package com.api.paycaratula.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Tomador {

    private String tomador;
    private Long idenTomador;
    private String correoTomador;
    private Long telTomador;
    private String dirTomador;
}
