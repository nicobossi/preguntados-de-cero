package com.guitarradecero.preguntados_de_cero.dto;

import com.guitarradecero.preguntados_de_cero.model.Nivel;

public record NivelDTO (

    Long id,
    String nombre

) {
    public static NivelDTO desdeModelo(Nivel n) {
        return new NivelDTO(n.getId(), n.getNombre());
    }
}
