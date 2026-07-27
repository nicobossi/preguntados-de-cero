package com.guitarradecero.preguntados_de_cero.security.filters;

public class TokenException extends RuntimeException {
    public TokenException(String message) {
        super(message);
    }
}
