package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.security.filters.TokenException;

public interface JwtService {
    String generateToken(User user);
    String getPayload(String token) throws TokenException;
}
