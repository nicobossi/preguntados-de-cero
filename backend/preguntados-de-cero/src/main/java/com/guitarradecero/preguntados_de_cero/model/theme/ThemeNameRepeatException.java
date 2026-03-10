package com.guitarradecero.preguntados_de_cero.model.theme;

import com.guitarradecero.preguntados_de_cero.model.ModelException;

public class ThemeNameRepeatException extends ModelException {
    public ThemeNameRepeatException(String message) {
        super(message);
    }
}
