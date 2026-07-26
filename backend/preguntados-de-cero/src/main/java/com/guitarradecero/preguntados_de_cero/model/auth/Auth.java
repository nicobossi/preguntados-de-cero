package com.guitarradecero.preguntados_de_cero.model.auth;

public record Auth(
        String email,
        String password,
        String token,
        Long id
) {
}
