package com.guitarradecero.preguntados_de_cero.configuration.jwt.jwtService;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String getToken(UserDetails user);
    String getEmailFromToken(String token);
    boolean isValidToken(String token, UserDetails userDetails);
}
