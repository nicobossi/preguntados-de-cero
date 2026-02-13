package com.guitarradecero.preguntados_de_cero.service.exception;

import com.guitarradecero.preguntados_de_cero.model.ModelException;

public class NotFoundException extends ModelException {
    public NotFoundException(String message) {
        super(message);
    }
}
