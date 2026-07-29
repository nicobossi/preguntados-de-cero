package com.guitarradecero.preguntados_de_cero.security.filters;

import org.springframework.security.core.AuthenticationException;

public class TokenException extends AuthenticationException {
    public TokenException(String message) {
        super(message);
    }
}
