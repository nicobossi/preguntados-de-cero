package com.guitarradecero.preguntados_de_cero.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String getToken(UserDetails user);

    String getEmailFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
