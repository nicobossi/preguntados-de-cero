package com.guitarradecero.preguntados_de_cero.controller.errorHandler.model;

import java.util.Date;

public record ErrorModelResponse(
        String message,
        Date date
) {
}
