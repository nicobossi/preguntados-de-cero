package com.guitarradecero.preguntados_de_cero.model.question;

import com.guitarradecero.preguntados_de_cero.model.ModelException;

public class RepeatedCorrectOptionException extends ModelException {
    protected RepeatedCorrectOptionException(String message) {
        super(message);
    }
}
